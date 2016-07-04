package com.worldtrival.bean;

public class SearchContinent {
	private String goods_id , name , market_price , shop_price ,
	app_cut_price_desc , goods_img;

	
	
	
	public SearchContinent() {
		super();
	}

	public SearchContinent(String goods_id, String name, String market_price,
			String shop_price, String app_cut_price_desc, String goods_img) {
		super();
		this.goods_id = goods_id;
		this.name = name;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.app_cut_price_desc = app_cut_price_desc;
		this.goods_img = goods_img;
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

	public String getMarket_price() {
		return market_price;
	}

	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public String getShop_price() {
		return shop_price;
	}

	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

	public String getApp_cut_price_desc() {
		return app_cut_price_desc;
	}

	public void setApp_cut_price_desc(String app_cut_price_desc) {
		this.app_cut_price_desc = app_cut_price_desc;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	@Override
	public String toString() {
		return "SearchContinent [goods_id=" + goods_id + ", name=" + name
				+ ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", app_cut_price_desc=" + app_cut_price_desc
				+ ", goods_img=" + goods_img + "]";
	}
	
}
