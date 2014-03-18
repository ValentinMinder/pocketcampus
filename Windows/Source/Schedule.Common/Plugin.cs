// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using PocketCampus.Common;
using PocketCampus.Mvvm;
using PocketCampus.Schedule.Services;
using PocketCampus.Schedule.ViewModels;

namespace PocketCampus.Schedule
{
    /// <summary>
    /// The schedule plugin.
    /// </summary>
    public class Plugin : IPlugin
    {
        /// <summary>
        /// Gets the plugin's ID.
        /// </summary>
        public string Id
        {
            get { return "DISABLED IsAcademia"; }
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
            Container.Bind<IScheduleService, ScheduleService>();
        }

        /// <summary>
        /// Navigates to the plugin's main ViewModel.
        /// </summary>
        public void NavigateTo( INavigationService navigationService )
        {
            navigationService.NavigateTo<MainViewModel>();
        }
    }
}