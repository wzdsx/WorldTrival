package com.worldtrival.message;

public class MessageModel {
	private String img;
	private String tv_head;
	private String tv_cont;
	private String tv_time;
	private int img_share;
	private String url;
	public MessageModel() {
		super();
	}

	public MessageModel(String img, String tv_head, String tv_cont, String tv_time,
			String url,int img_share) {
		super();
		this.img = img;
		this.tv_head = tv_head;
		this.tv_cont = tv_cont;
		this.tv_time = tv_time;
		this.img_share = img_share;
		this.url = url;
	}
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTv_head() {
		return tv_head;
	}

	public void setTv_head(String tv_head) {
		this.tv_head = tv_head;
	}

	public String getTv_cont() {
		return tv_cont;
	}

	public void setTv_cont(String tv_cont) {
		this.tv_cont = tv_cont;
	}

	public String getTv_time() {
		return tv_time;
	}

	public void setTv_time(String tv_time) {
		this.tv_time = tv_time;
	}

	public int getImg_share() {
		return img_share;
	}

	public void setImg_share(int img_share) {
		this.img_share = img_share;
	}

}
