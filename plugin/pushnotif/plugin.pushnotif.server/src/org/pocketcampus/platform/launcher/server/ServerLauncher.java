package org.pocketcampus.platform.launcher.server;

import java.util.ArrayList;

import org.pocketcampus.plugin.pushnotif.server.PushNotifServiceImpl;
import org.pocketcampus.plugin.pushnotif.shared.PushNotifService;


public class ServerLauncher {
	
	public static class PocketCampusServer extends ServerBase {
		protected ArrayList<Processor> getServiceProcessors() {
			ArrayList<Processor> processors = new ArrayList<Processor>();
			processors.add(new Processor(new PushNotifService.Processor<PushNotifServiceImpl>(new PushNotifServiceImpl()), "pushnotif"));
			return processors;
		}
	}
	
	public static void main(String[] args) throws Exception {
		ServerBase server = new PocketCampusServer();
		server.start();
	}
	
}
