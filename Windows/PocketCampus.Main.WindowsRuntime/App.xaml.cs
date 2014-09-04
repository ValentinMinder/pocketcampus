﻿using System.Linq;
using PocketCampus.Common;
using PocketCampus.Common.Services;
using PocketCampus.Main.Services;
using PocketCampus.Main.ViewModels;
using PocketCampus.Main.Views;
using ThinMvvm;
using ThinMvvm.WindowsRuntime;
using Windows.ApplicationModel.Activation;
using Windows.Phone.UI.Input;
using Windows.UI.Xaml;

namespace PocketCampus.Main
{
    public sealed partial class App : AppBase
    {
        private readonly IWindowsRuntimeNavigationService _navigationService;
        private readonly IPluginLoader _pluginLoader;

        public App()
        {
            RequestedTheme = ApplicationTheme.Light;

            Container.Bind<ISettingsStorage, WindowsRuntimeSettingsStorage>();
            Container.Bind<IDataCache, WindowsRuntimeDataCache>();
            Container.Bind<IHttpClient, HttpClient>();
            Container.Bind<IBrowserService, BrowserService>();
            Container.Bind<IEmailService, EmailService>();
            Container.Bind<IPhoneService, PhoneService>();
            Container.Bind<ILocationService, LocationService>();
            Container.Bind<ITileService, TileService>();
            Container.Bind<IDeviceIdentifier, DeviceIdentifier>();
            Container.Bind<IRatingService, RatingService>();
            Container.Bind<ICredentialsStorage, CredentialsStorage>();

            _navigationService = Container.Bind<IWindowsRuntimeNavigationService, WindowsRuntimeNavigationService>();
            _pluginLoader = Container.Bind<IPluginLoader, PluginLoader>();

            _navigationService.Bind<AboutViewModel, AboutView>();
            _navigationService.Bind<MainViewModel, MainView>();
            _navigationService.Bind<SettingsViewModel, SettingsView>();

            HardwareButtons.BackPressed += ( _, e ) =>
            {
                e.Handled = true;
                _navigationService.NavigateBack();
            };
        }

        protected override async void Launch( LaunchActivatedEventArgs e )
        {
            // TODO launch from a tile
            // TODO launch from protocol


            await AppInitializer.InitializeAsync( _pluginLoader, _navigationService );

            foreach ( var plugin in ( await _pluginLoader.GetPluginsAsync() ).Cast<IWindowsRuntimePlugin>() )
            {
                plugin.Initialize( _navigationService );
            }

            _navigationService.NavigateTo<MainViewModel>();
        }
    }
}