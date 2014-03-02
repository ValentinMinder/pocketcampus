﻿using System;
using System.Collections.Generic;
using System.Windows;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using PocketCampus.Common.Controls;
using PocketCampus.Events.Models;
using PocketCampus.Events.Resources;
using PocketCampus.Events.ViewModels;

namespace PocketCampus.Events.Views
{
    public partial class EventPoolView : BasePage
    {
        public EventPoolView()
        {
            Loaded += This_Loaded;
            InitializeComponent();
        }

        private void This_Loaded( object sender, RoutedEventArgs e )
        {
            var vm = (EventPoolViewModel) DataContext;

            vm.PropertyChanged += ( s, pce ) =>
            {
                if ( pce.PropertyName != "Pool" )
                {
                    return;
                }

                var buttons = new List<ApplicationBarIconButton>();
                var items = new List<ApplicationBarMenuItem>();

                // Settings
                if ( vm.Pool.Id == EventPool.RootId )
                {
                    var button = new ApplicationBarIconButton
                    {
                        IconUri = new Uri( "/Assets/Settings.png", UriKind.Relative ),
                        Text = PluginResources.FilterCategoriesButton
                    };
                    button.Click += ( _, __ ) => vm.ViewSettingsCommand.Execute();
                    buttons.Add( button );
                }

                // Filter categories
                if ( vm.Pool.DisableCategoryFiltering != true )
                {
                    var button = new ApplicationBarIconButton
                    {
                        IconUri = new Uri( "/Assets/Filter.png", UriKind.Relative ),
                        Text = PluginResources.FilterCategoriesButton
                    };
                    button.Click += ( _, __ ) => vm.FilterByCategoryCommand.Execute();
                    buttons.Add( button );
                }

                // Filter tags
                if ( vm.Pool.DisableTagFiltering != true )
                {
                    var button = new ApplicationBarIconButton
                    {
                        IconUri = new Uri( "/Assets/Tags.png", UriKind.Relative ),
                        Text = PluginResources.FilterTagsButton
                    };
                    button.Click += ( _, __ ) => vm.FilterByTagCommand.Execute();
                    buttons.Add( button );
                }

                // Scan code
                if ( vm.Pool.EnableCodeScanning == true )
                {
                    var button = new ApplicationBarIconButton
                    {
                        IconUri = new Uri( "/Assets/QRCode.png", UriKind.Relative ),
                        Text = PluginResources.ScanCodeButton
                    };
                    button.Click += ( _, __ ) => vm.ScanCodeCommand.Execute();
                    buttons.Add( button );
                }

                // Send favorite email
                if ( vm.Pool.EnableFavoriteEmailRequest == true )
                {
                    var item = new ApplicationBarMenuItem
                    {
                        Text = PluginResources.SendFavoriteEmailButton
                    };
                    item.Click += ( _, __ ) => vm.RequestFavoriteEmailCommand.ExecuteAsync();
                }

                if ( buttons.Count + items.Count == 0 )
                {
                    ApplicationBar = null;
                }
                else
                {
                    var bar = new ApplicationBar();

                    foreach ( var button in buttons )
                    {
                        bar.Buttons.Add( button );
                    }

                    foreach ( var item in items )
                    {
                        bar.MenuItems.Add( item );
                    }

                    bar.Mode = buttons.Count == 0 ? ApplicationBarMode.Minimized : ApplicationBarMode.Default;
                    bar.MatchOverriddenTheme();

                    ApplicationBar = bar;
                }
            };
        }
    }
}