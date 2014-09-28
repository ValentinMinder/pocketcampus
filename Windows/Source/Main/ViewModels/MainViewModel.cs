// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System;
using System.Diagnostics;
using System.Linq;
using PocketCampus.Authentication;
using PocketCampus.Common;
using PocketCampus.Main.Services;
using ThinMvvm;
using ThinMvvm.Logging;
using AuthenticationViewModel = PocketCampus.Authentication.ViewModels.MainViewModel;

namespace PocketCampus.Main.ViewModels
{
    [LogId( "/dashboard" )]
    public sealed class MainViewModel : ViewModel<NoParameter>
    {
        private readonly INavigationService _navigationService;
        private readonly IPluginLoader _pluginLoader;
        private readonly IMainSettings _settings;
        private readonly ITileService _tileCreator;

        private IPlugin[] _plugins;


        public IPlugin[] Plugins
        {
            get { return _plugins; }
            private set { SetProperty( ref _plugins, value ); }
        }


        [LogId( "OpenAbout" )]
        public Command OpenAboutPageCommand
        {
            get { return this.GetCommand( _navigationService.NavigateTo<AboutViewModel> ); }
        }

        [LogId( "OpenSettings" )]
        public Command OpenSettingsPageCommand
        {
            get { return this.GetCommand( _navigationService.NavigateTo<SettingsViewModel> ); }
        }

        [LogId( "CreatePluginTile" )]
        [LogParameter( "$Param.Id" )]
        public Command<IPlugin> CreatePluginTileCommand
        {
            get { return this.GetCommand<IPlugin>( p => _tileCreator.CreateTile( p ) ); }
        }

        [LogId( "OpenPlugin" )]
        [LogParameter( "$Param.Id" )]
        public Command<IPlugin> OpenPluginCommand
        {
            get { return this.GetCommand<IPlugin>( OpenPlugin ); }
        }


        public MainViewModel( INavigationService navigationService, IPluginLoader pluginLoader, IMainSettings settings, ITileService tileCreator )
        {
            _navigationService = navigationService;
            _pluginLoader = pluginLoader;
            _settings = settings;
            _tileCreator = tileCreator;
        }


        public override void OnNavigatedTo()
        {
            if ( Plugins == null )
            {
                Plugins = _pluginLoader.GetPlugins().Where( p => p.IsVisible ).ToArray();
                FilterPlugins();
            }
        }


        [Conditional( "RELEASE" )]
        private void FilterPlugins()
        {
            Plugins = Plugins.Where( p => _settings.Configuration.EnabledPlugins.Any( id => id.Equals( p.Id, StringComparison.OrdinalIgnoreCase ) ) ).ToArray();
        }


        private void OpenPlugin( IPlugin plugin )
        {
            if ( !plugin.RequiresAuthentication || _settings.SessionStatus != SessionStatus.NotLoggedIn )
            {
                plugin.NavigateTo( _navigationService );
            }
            else if ( _settings.SessionStatus == SessionStatus.NotLoggedIn )
            {
                var authRequest = new AuthenticationRequest( () => plugin.NavigateTo( _navigationService ) );
                _navigationService.NavigateTo<AuthenticationViewModel, AuthenticationRequest>( authRequest );
            }
        }
    }
}