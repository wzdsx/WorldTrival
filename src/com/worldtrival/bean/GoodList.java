package com.worldtrival.bean;

public class GoodList {
	private String name , img , url;

	public GoodList(String name, String img, String url) {
		super();
		this.name = name;
		this.img = img;
		this.url = url;
	}

	public GoodList() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "GoodList [name=" + name + ", img=" + img + ", url=" + url + "]";
	}
	
}
