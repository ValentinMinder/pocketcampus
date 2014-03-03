﻿// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using PocketCampus.Common;
using PocketCampus.Events.Models;
using PocketCampus.Events.Services;
using PocketCampus.Mvvm;
using PocketCampus.Mvvm.Logging;

namespace PocketCampus.Events.ViewModels
{
    [LogId( "/events" )]
    public sealed class EventPoolViewModel : DataViewModel<ViewPoolRequest>
    {
        private readonly INavigationService _navigationService;
        private readonly IEventsService _eventsService;
        private readonly IPluginSettings _settings;
        private readonly IEmailPrompt _emailPrompt;
        private readonly ICodeScanner _codeScanner;
        private readonly long _poolId;

        private EventPool _pool;
        private EventItemGroup[] _itemGroups;
        private bool _anyItems;
        private EmailSendingStatus _emailStatus;

        public EventPool Pool
        {
            get { return _pool; }
            private set { SetProperty( ref _pool, value ); }
        }

        public EventItemGroup[] ItemGroups
        {
            get { return _itemGroups; }
            private set { SetProperty( ref _itemGroups, value ); }
        }

        public bool AnyItems
        {
            get { return _anyItems; }
            private set { SetProperty( ref _anyItems, value ); }
        }

        public EmailSendingStatus EmailStatus
        {
            get { return _emailStatus; }
            private set { SetProperty( ref _emailStatus, value ); }
        }

        [LogId( "ShowEvent" )]
        public Command<EventItem> ViewItemCommand
        {
            get { return GetCommand<EventItem>( item => _navigationService.NavigateTo<EventItemViewModel, long>( item.Id ) ); }
        }

        [LogId( "ShowCategories" )]
        public Command FilterByCategoryCommand
        {
            get { return GetCommand( () => _navigationService.NavigateTo<CategoryFilterViewModel, EventPool>( Pool ), () => Pool.DisableCategoryFiltering != true ); }
        }

        [LogId( "ShowTags" )]
        public Command FilterByTagCommand
        {
            get { return GetCommand( () => _navigationService.NavigateTo<TagFilterViewModel, EventPool>( Pool ), () => Pool.DisableTagFiltering != true ); }
        }

        [LogId( "ShowSettings" )]
        public Command ViewSettingsCommand
        {
            get { return GetCommand( _navigationService.NavigateTo<SettingsViewModel> ); }
        }

        [LogId( "RequestEmail" )]
        public AsyncCommand RequestFavoriteEmailCommand
        {
            get { return GetAsyncCommand( RequestFavoriteEmailAsync, () => Pool.EnableFavoriteEmailRequest == true ); }
        }

        [LogId( "ShowCodeScanner" )]
        public Command ScanCodeCommand
        {
            get { return GetCommand( _codeScanner.ScanCode, () => Pool.EnableCodeScanning == true ); }
        }

        public EventPoolViewModel( INavigationService navigationService, IEventsService eventsService,
                                   IPluginSettings settings, IEmailPrompt emailPrompt, ICodeScanner codeScanner,
                                   ViewPoolRequest request )
        {
            _navigationService = navigationService;
            _eventsService = eventsService;
            _settings = settings;
            _emailPrompt = emailPrompt;
            _codeScanner = codeScanner;
            _poolId = request.PoolId;

            if ( request.UserTicket != null )
            {
                _settings.UserTickets.Add( request.UserTicket );
            }
        }

        protected override async Task RefreshAsync( CancellationToken token, bool force )
        {
            if ( force || ( _pool != null && _pool.AlwaysRefresh == true ) )
            {
                if ( !_settings.ExcludedCategoriesByPool.ContainsKey( _poolId ) )
                {
                    _settings.ExcludedCategoriesByPool.Add( _poolId, new List<int>() );
                }
                if ( !_settings.ExcludedTagsByPool.ContainsKey( _poolId ) )
                {
                    _settings.ExcludedTagsByPool.Add( _poolId, new List<string>() );
                }

                var request = new EventPoolRequest
                {
                    PoolId = _poolId,
                    DayCount = (int) _settings.SearchPeriod,
                    IsInPast = _settings.SearchInPast,
                    UserTickets = _settings.UserTickets.ToArray(),
                    FavoriteEventIds = _settings.FavoriteEventIds.ToArray(),
                    Language = CultureInfo.CurrentUICulture.TwoLetterISOLanguageName
                };
                var response = await _eventsService.GetEventPoolAsync( request );

                if ( response.Status != EventsStatusCode.OK )
                {
                    throw new Exception( "An error occurred while fetching the event pool." );
                }

                _settings.EventTags = response.EventTags;
                _settings.EventCategories = response.EventCategories;

                Pool = response.Pool;
                Pool.Items = response.ChildrenItems == null ? new EventItem[0] : response.ChildrenItems.Values.ToArray();
                AnyItems = Pool.Items.Any();

                foreach ( var item in Pool.Items )
                {
                    item.ParentPool = Pool;
                }

                if ( Pool.Id == EventPool.RootId )
                {
                    Pool.AlwaysRefresh = true;
                }
            }

            var groups = from item in Pool.Items
                         where item.CategoryId == null
                            || !_settings.ExcludedCategoriesByPool[_poolId].Contains( item.CategoryId.Value )
                         where item.TagIds == null
                            || !item.TagIds.Any( _settings.ExcludedTagsByPool[_poolId].Contains )
                         orderby item.TimeOverride ascending,
                                 item.StartDate descending,
                                 item.EndDate ascending,
                                 item.Name ascending
                         group item by item.CategoryId into itemGroup
                         let categName = itemGroup.Key.HasValue
                                      && _settings.EventCategories.ContainsKey( itemGroup.Key.Value )
                                       ? _settings.EventCategories[itemGroup.Key.Value]
                                       : "???"
                         orderby categName ascending
                         select new EventItemGroup( categName, itemGroup );

            ItemGroups = groups.ToArray();
        }

        private async Task RequestFavoriteEmailAsync()
        {
            EmailStatus = EmailSendingStatus.NoneRequested;

            string emailAddress = _emailPrompt.GetEmail();

            if ( emailAddress == null )
            {
                return;
            }

            try
            {
                var request = new FavoriteEmailRequest
                {
                    EmailAddress = emailAddress,
                    PoolId = Pool.Id,
                    FavoriteItems = _settings.FavoriteEventIds.ToArray(),
                    UserTickets = _settings.UserTickets.ToArray(),
                    Language = CultureInfo.CurrentUICulture.TwoLetterISOLanguageName
                };

                var response = await _eventsService.SendFavoriteItemsByEmailAsync( request );

                if ( response.Status != EventsStatusCode.OK )
                {
                    throw new Exception( "An error occurred while requesting an e-mail with the favorites." );
                }

                EmailStatus = EmailSendingStatus.Success;
            }
            catch
            {
                EmailStatus = EmailSendingStatus.Error;
            }
        }
    }
}