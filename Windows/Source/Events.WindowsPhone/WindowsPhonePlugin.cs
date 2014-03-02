﻿using System;
using PocketCampus.Common;
using PocketCampus.Common.Services;
using PocketCampus.Events.Resources;
using PocketCampus.Events.Services;
using PocketCampus.Events.ViewModels;
using PocketCampus.Mvvm;

namespace PocketCampus.Events.WindowsPhone
{
    public sealed class WindowsPhonePlugin : Plugin, IWindowsPhonePlugin
    {
        public string Name
        {
            get { return PluginResources.PluginName; }
        }

        public Uri Icon
        {
            get { return new Uri( "/Assets/EventsIcon.png", UriKind.Relative ); }
        }

        public Uri SmallIcon
        {
            get { return new Uri( "/Assets/EventsSmallIcon.png", UriKind.Relative ); }
        }

        public void Initialize( IWindowsPhoneNavigationService navigationService )
        {
            navigationService.Bind<EventPoolViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/EventPoolView.xaml" );
            navigationService.Bind<EventItemViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/EventItemView.xaml" );
            navigationService.Bind<SettingsViewModel>( "/PocketCampus.Events.WindowsPhone;component/Views/SettingsView.xaml" );

            Container.Bind<IEmailPrompt, EmailPrompt>();
            Container.Bind<IPluginSettings, PluginSettings>();
        }
    }
}