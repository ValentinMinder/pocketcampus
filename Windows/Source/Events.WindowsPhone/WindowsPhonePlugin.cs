﻿// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System;
using PocketCampus.Common;
using PocketCampus.Common.Services;
using PocketCampus.Events.Resources;
using PocketCampus.Events.Services;
using PocketCampus.Events.ViewModels;
using PocketCampus.Mvvm;

namespace PocketCampus.Events.WindowsPhone
{
    /// <summary>
    /// The Events Windows Phone plugin.
    /// </summary>
    public sealed class WindowsPhonePlugin : Plugin, IWindowsPhonePlugin
    {
        /// <summary>
        /// Gets the plugin's name.
        /// </summary>
        public string Name
        {
            get { return PluginResources.PluginName; }
        }

        /// <summary>
        /// Gets the plugin's icon (as an Uri).
        /// </summary>
        public Uri Icon
        {
            get { return new Uri( "/Assets/EventsIcon.png", UriKind.Relative ); }
        }

        /// <summary>
        /// Gets the plugin's small icon (as an Uri).
        /// </summary>
        public Uri SmallIcon
        {
            get { return new Uri( "/Assets/EventsSmallIcon.png", UriKind.Relative ); }
        }

        /// <summary>
        /// Initializes the Windows Phone specific part of the plugin.
        /// </summary>
        public void Initialize( IWindowsPhoneNavigationService navigationService )
        {
            navigationService.Bind<EventPoolViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/EventPoolView.xaml" );
            navigationService.Bind<EventItemViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/EventItemView.xaml" );
            navigationService.Bind<SettingsViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/SettingsView.xaml" );
            navigationService.Bind<CategoryFilterViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/CategoryFilterView.xaml" );
            navigationService.Bind<TagFilterViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/TagFilterView.xaml" );

            Container.Bind<IEmailPrompt, EmailPrompt>();
            Container.Bind<ICodeScanner, CodeScanner>();
            Container.Bind<IPluginSettings, PluginSettings>();
        }
    }
}