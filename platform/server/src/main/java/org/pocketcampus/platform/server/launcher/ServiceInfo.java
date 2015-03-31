package org.pocketcampus.platform.server.launcher;

import org.apache.thrift.TProcessor;
import org.pocketcampus.platform.server.StateChecker;
import org.pocketcampus.platform.server.TaskRunner;

import javax.servlet.http.HttpServlet;

public final class ServiceInfo {
	public final String name;
	public final TProcessor thriftProcessor;
	public final HttpServlet rawProcessor;
	public final StateChecker stateChecker;
	public final TaskRunner taskRunner;

	public ServiceInfo(final String name, final TProcessor thriftProcessor, final HttpServlet rawProcessor, final StateChecker stateChecker, final TaskRunner taskRunner) {
		this.name = name;
		this.thriftProcessor = thriftProcessor;
		this.rawProcessor = rawProcessor;
		this.stateChecker = stateChecker;
		this.taskRunner = taskRunner;
	}
}