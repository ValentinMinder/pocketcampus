﻿// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

// Design data for MainViewModel

using System;
using PocketCampus.Common.Services.Design;
using PocketCampus.Moodle.Services.Design;
using PocketCampus.Moodle.ViewModels;
using ThinMvvm;
using ThinMvvm.WindowsPhone.Design;

namespace PocketCampus.Moodle.Views.Design
{
    public sealed class DesignMainViewModel : DesignViewModel<MainViewModel>
    {
#if DEBUG
        private MainViewModel _viewModel;
        protected override MainViewModel ViewModel
        {
            get
            {
                if ( _viewModel == null )
                {
                    _viewModel = new MainViewModel( new DesignDataCache(), new DesignSecureRequestHandler(), new DesignNavigationService(), new DesignMoodleService() );
                    _viewModel.OnNavigatedToAsync().Wait();
                }
                return _viewModel;
            }
        }

#warning this should not exist
        private sealed class DesignDataCache : IDataCache
        {
            public void Set( Type owner, long id, DateTime expirationDate, object value ) { }

            public bool TryGet<T>( Type owner, long id, out T value )
            {
                value = default( T );
                return false;
            }
        }
#endif
    }
}