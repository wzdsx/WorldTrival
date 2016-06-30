package com.worldtrival.bean;

public class Recommend {
	 private String goods_name,goods_id,url;

	public Recommend(String goods_name, String goods_id , String url) {
		super();
		this.goods_name = goods_name;
		this.goods_id = goods_id;
		this.url = url;
	}

	
	public Recommend(String goods_name, String goods_id) {
		super();
		this.goods_name = goods_name;
		this.goods_id = goods_id;
	}


	public Recommend() {
		super();
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Recommend [goods_name=" + goods_name + ", goods_id=" + goods_id
				+ "]";
	}
	
	
}
