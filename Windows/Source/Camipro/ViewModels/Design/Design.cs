﻿// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

// Design data for ViewModels

#if DEBUG
using PocketCampus.Camipro.Services.Design;
using PocketCampus.Common.Services.Design;
#endif

namespace PocketCampus.Camipro.ViewModels.Design
{
    public sealed class Design
    {
#if DEBUG
        public MainViewModel Main { get; private set; }

        public Design()
        {
            Main = new MainViewModel( new DesignCamiproService(), new DesignSecureRequestHandler() );

            Main.OnNavigatedToAsync();
        }
#endif
    }
}