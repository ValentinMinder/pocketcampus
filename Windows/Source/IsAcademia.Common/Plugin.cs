// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System.Collections.Generic;
using PocketCampus.Common;
using PocketCampus.IsAcademia.Services;
using PocketCampus.IsAcademia.ViewModels;
using PocketCampus.Mvvm;

namespace PocketCampus.IsAcademia
{
    /// <summary>
    /// The IS-Academia plugin.
    /// </summary>
    public class Plugin : IPlugin
    {
        /// <summary>
        /// Gets the plugin's ID.
        /// </summary>
        public string Id
        {
            get { return "IsAcademia"; }
        }

        /// <summary>
        /// This plugin requires authentication.
        /// </summary>
        public bool RequiresAuthentication
        {
            get { return true; }
        }

        /// <summary>
        /// Initializes the plugin.
        /// </summary>
        public void Initialize( INavigationService navigationService )
        {
            Container.Bind<IIsAcademiaService, IsAcademiaService>();
        }

        /// <summary>
        /// Navigates to the plugin's main ViewModel.
        /// </summary>
        public void NavigateTo( INavigationService navigationService )
        {
            navigationService.NavigateTo<MainViewModel>();
        }

        /// <summary>
        /// This plugin does not handle external navigation.
        /// </summary>
        public void NavigateTo( string destination, IDictionary<string, string> parameters, INavigationService navigationService ) { }
    }
}