package org.pocketcampus.core.communication;


public abstract class DataRequest extends Request<String> {
	
	protected int expirationDelay() {
		// default 0 seconds
		return 0;
	}
	
	@Override
	protected int timeoutDelay() {
		// default 12 seconds (5 seemed to be too short)
		return 12;
	}
	
	protected final String getUrl() {
		return serverUrl_ + pluginInfo_.getId() + "/" + command_ + ".do";
	}
	
	@Override
	protected final String loadFromServer(String url) {
		String result = null;
		HttpRequest req = new HttpRequest(url);
		
		try {
			result = req.getContent();
		} catch (Exception e) {
			exception_ = e;
		}

		return result;
	}
	
}






