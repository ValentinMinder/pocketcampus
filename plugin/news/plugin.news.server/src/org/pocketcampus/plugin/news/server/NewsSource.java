package org.pocketcampus.plugin.news.server;

import java.util.Map;

import org.joda.time.DateTime;

public interface NewsSource {
	Feed[] getFeeds(String language);

	public static class Feed {
		public final String name;
		public final boolean isMain;
		public final Map<Integer, FeedItem> items;

		public Feed(String name, boolean isMain, Map<Integer, FeedItem> items) {
			this.name = name;
			this.isMain = isMain;
			this.items = items;
		}
	}

	public static class FeedItem {
		public final int id;
		public final String title;
		public final String link;
		public final DateTime publishDate;
		public final String imageUrl;
		public final String content;

		public FeedItem(int id, String title, String link, DateTime publishDate, String imageUrl, String content) {
			this.id = id;
			this.title = title;
			this.link = link;
			this.publishDate = publishDate;
			this.imageUrl = imageUrl;
			this.content = content;
		}
	}
}