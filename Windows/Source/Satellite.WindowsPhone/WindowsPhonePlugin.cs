// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System;
using PocketCampus.Common;
using PocketCampus.Common.Services;
using PocketCampus.Satellite.Resources;
using PocketCampus.Satellite.ViewModels;

namespace PocketCampus.Satellite
{
    /// <summary>
    /// The Satellite Windows Phone plugin.
    /// </summary>
    public sealed class WindowsPhonePlugin : Plugin, IWindowsPhonePlugin
    {
        /// <summary>
        /// Gets the plugin's localized name.
        /// </summary>
        public string Name
        {
            get { return PluginResources.PluginName; }
        }

        /// <summary>
        /// Gets the plugin's icon.
        /// </summary>
        public Uri Icon
        {
            get { return new Uri( "/Assets/SatelliteIcon.png", UriKind.Relative ); }
        }

        /// <summary>
        /// Gets the plugin's small icon.
        /// </summary>
        public Uri SmallIcon
        {
            get { return new Uri( "/Assets/SatelliteSmallIcon.png", UriKind.Relative ); }
        }

        /// <summary>
        /// Initializes the Windows Phone specific part of the plugin.
        /// </summary>
        public void Initialize( IWindowsPhoneNavigationService navigationService )
        {
            navigationService.Bind<MainViewModel>( "/PocketCampus.Satellite.WindowsPhone;component/Views/MainView.xaml" );
        }
    }
}