package org.pocketcampus.plugin.news;

/**
 * A class that describes a news item, to be displayed by the News plugins
 * 
 * @status complete, some attributes can be added.
 * @author jonas, johan
 * @license 
 *
 */

public class NewsItem {
	private String title_;
	private String description_;
	private String link_;
	private String pubDate_;
	private String image_;
	
	public NewsItem() { }
	
	
	
	public NewsItem(String title_, String description_, String link_,
			String pubDate_, String image_) {
		super();
		this.title_ = title_;
		this.description_ = description_;
		this.link_ = link_;
		this.pubDate_ = pubDate_;
		this.image_ = image_;
	}



	public NewsItem clone() {
		NewsItem fd = new NewsItem();
		fd.title_ = this.title_;
		fd.description_ = this.description_;
		fd.link_ = this.link_;
		fd.pubDate_ = this.pubDate_;
		fd.image_ = this.image_;
		return fd;
	}
	
	public String getImage() {
		return image_;
	}
	
	public void setImage(String image) {
		image_ = image;
	}
	
	public String getTitle() {
		return title_;
	}

	public void setTitle(String title) {
		this.title_ = title;
	}

	public String getDescription() {
		return description_;
	}

	public void setDescription(String description) {
		this.description_ = description;
	}

	public String getLink() {
		return link_;
	}

	public void setLink(String link) {
		this.link_ = link;
	}

	public String getPubDate() {
		return pubDate_;
	}

	public void setPubDate(String pubDate) {
		this.pubDate_ = pubDate;
	}
	
}
