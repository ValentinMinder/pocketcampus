package org.pocketcampus.plugin.directory.server;

import org.pocketcampus.platform.launcher.server.PocketCampusServer;

public class ServerLauncher {
	
	public static void main(String[] args) throws Exception {
		new PocketCampusServer().start();
	}
	
}