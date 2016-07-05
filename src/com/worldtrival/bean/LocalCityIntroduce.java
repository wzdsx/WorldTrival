package com.worldtrival.bean;

public class LocalCityIntroduce {

	private String goods_id, name, summary, distance, img_url;

	public LocalCityIntroduce(String goods_id, String name, String summary,
			String distance, String img_url) {
		super();
		this.goods_id = goods_id;
		this.name = name;
		this.summary = summary;
		this.distance = distance;
		this.img_url = img_url;
	}
	
	public LocalCityIntroduce() {
		super();
		
	}


	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	
}
