package com.worldtrival.bean;

public class GoodList {
	private String name , img , url , id;

	public GoodList(String name, String img, String url , String id) {
		super();
		this.name = name;
		this.img = img;
		this.url = url;
		this.id = id;
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
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GoodList [name=" + name + ", img=" + img + ", url=" + url + "]";
	}
	
}
