// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

// Design data for the SettingsViewModel

using System.Collections.Generic;
using System.ComponentModel;
using PocketCampus.Common;
namespace PocketCampus.Main.ViewModels.Design
{
    public sealed class DesignSettingsViewModel
    {
#if DEBUG
        public IMainSettings Settings { get { return new DesignMainSettings(); } }

        private sealed class DesignMainSettings : IMainSettings
        {
            public bool IsFirstRun
            {
                get { return false; }
                set { }
            }

            public ServerConfiguration Configuration
            {
                get { return new ServerConfiguration( "https", 4433, "Moodle", "Food" ); }
                set { }
            }

            public AuthenticationStatus AuthenticationStatus
            {
                get { return AuthenticationStatus.AuthenticatedTemporarily; }
                set { }
            }

            public string UserName
            {
                get { return "johndoe"; }
                set { }
            }

            public string Password
            {
                get { return "12345"; }
                set { }
            }

            public string Session
            {
                get { return null; }
                set { }
            }

            public Dictionary<string, string> Sessions
            {
                get { return null; }
                set { }
            }

            public event PropertyChangedEventHandler PropertyChanged;
            public void IgnoreAboveEvent() { PropertyChanged( null, null ); }
        }
#endif
    }
}