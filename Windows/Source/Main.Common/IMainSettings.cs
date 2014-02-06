// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using System.Collections.Generic;
namespace PocketCampus.Main
{
    /// <summary>
    /// Contains various application-level settings.
    /// </summary>
    public interface IMainSettings
    {
        /// <summary>
        /// Gets or sets a value indicating whether this is the app's first run.
        /// </summary>
        bool IsFirstRun { get; set; }

        /// <summary>
        /// Gets or sets a value indicating whether the user is authenticated.
        /// </summary>
        bool IsAuthenticated { get; set; }

        /// <summary>
        /// Gets or sets the GASPAR username (or the SCIPER number), if the user is authenticated.
        /// </summary>
        string UserName { get; set; }

        /// <summary>
        /// Gets or sets the GASPAR password, if the user is authenticated.
        /// </summary>
        string Password { get; set; }

        /// <summary>
        /// Gets or sets the saved sessions.
        /// </summary>
        Dictionary<string, string> Sessions { get; set; }
    }
}