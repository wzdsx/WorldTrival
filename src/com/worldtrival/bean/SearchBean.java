package com.worldtrival.bean;

public class SearchBean {
	private String title, img_url, event_time, url, type;

	public SearchBean(String title, String img_url, String event_time,
			String url, String type) {
		super();
		this.title = title;
		this.img_url = img_url;
		this.event_time = event_time;
		this.type = type;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SearchBean() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SearchBean [title=" + title + ", img_url=" + img_url
				+ ", event_time=" + event_time + ", url=" + url + "]";
	}

}
