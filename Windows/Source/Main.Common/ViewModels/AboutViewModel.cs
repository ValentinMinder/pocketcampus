// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System.Reflection;
using PocketCampus.Common.Services;
using PocketCampus.Main.Services;
using PocketCampus.Mvvm;
using PocketCampus.Mvvm.Logging;

namespace PocketCampus.Main.ViewModels
{
    /// <summary>
    /// The ViewModel for the About page.
    /// </summary>
    [PageLogId( "/dashboard/about" )]
    public sealed class AboutViewModel : ViewModel<NoParameter>
    {
        private readonly IBrowserService _browserService;
        private readonly IEmailService _emailService;
        private readonly IRatingService _ratingService;

        /// <summary>
        /// Gets the app version.
        /// </summary>
        public string AppVersion
        {
            get { return typeof( AboutViewModel ).GetTypeInfo().Assembly.GetName().Version.ToString( 2 ); }
        }

        /// <summary>
        /// Gets the command executed to navigate to an URL.
        /// </summary>
        [CommandLogId( "ViewWebsite" )]
        public Command<string> BrowseUrlCommand
        {
            get { return GetCommand<string>( _browserService.NavigateTo ); }
        }

        [CommandLogId( "SendEmail" )]
        public Command<string> SendEmailCommand
        {
            get { return GetCommand<string>( _emailService.ComposeEmail ); }
        }

        /// <summary>
        /// Gets the command executed to rate the application.
        /// </summary>
        [CommandLogId( "RateOnStore" )]
        public Command RateAppCommand
        {
            get { return GetCommand( _ratingService.RequestRating ); }
        }


        /// <summary>
        /// Creates a new AboutViewModel.
        /// </summary>
        public AboutViewModel( IBrowserService browserService, IEmailService emailService, IRatingService ratingService )
        {
            _browserService = browserService;
            _emailService = emailService;
            _ratingService = ratingService;
        }
    }
}