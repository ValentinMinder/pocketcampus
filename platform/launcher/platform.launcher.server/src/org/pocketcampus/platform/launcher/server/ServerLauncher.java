package org.pocketcampus.platform.launcher.server;


public class ServerLauncher {
	public static void main(String[] args) throws Exception {
		ServerBase server = new PocketCampusServer();
		server.start();
	}
}
