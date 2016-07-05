package com.worldtrival.bean;



public class LocalGoodsBranch {
	private String goods_id, name, cat_id, dest_id, goods_img, market_price, shop_price, 
			latitude, longgitude, promote_price, img, goods_type, app_cut_price, app_cut_price_desc;

	

	public LocalGoodsBranch(String goods_id, String name, String market_price,
			String shop_price, String img, String app_cut_price, String app_cut_price_desc) {
		super();
		this.goods_id = goods_id;
		this.name = name;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.img = img;
		this.app_cut_price = app_cut_price;
		this.app_cut_price_desc = app_cut_price_desc;
	}

	
	

	



	public LocalGoodsBranch() {
		super();
	}








	public LocalGoodsBranch(String goods_id, String name, String cat_id,
			String dest_id, String goods_img, String marcket_price,
			String shop_price, String latitude, String longgitude,
			String promote_price, String img, String goods_type,
			String app_cut_price, String app_cut_price_desc) {
		super();
		this.goods_id = goods_id;
		this.name = name;
		this.cat_id = cat_id;
		this.dest_id = dest_id;
		this.goods_img = goods_img;
		this.market_price = marcket_price;
		this.shop_price = shop_price;
		this.latitude = latitude;
		this.longgitude = longgitude;
		this.promote_price = promote_price;
		this.img = img;
		this.goods_type = goods_type;
		this.app_cut_price = app_cut_price;
		this.app_cut_price_desc = app_cut_price_desc;
	}








	public String getGoods_id() {
		return goods_id;
	}



	public int size() {
		return 13;
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








	public String getCat_id() {
		return cat_id;
	}








	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}








	public String getDest_id() {
		return dest_id;
	}








	public void setDest_id(String dest_id) {
		this.dest_id = dest_id;
	}








	public String getGoods_img() {
		return goods_img;
	}








	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}








	public String getMarcket_price() {
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








	public String getLatitude() {
		return latitude;
	}








	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}








	public String getLonggitude() {
		return longgitude;
	}








	public void setLonggitude(String longgitude) {
		this.longgitude = longgitude;
	}








	public String getPromote_price() {
		return promote_price;
	}








	public void setPromote_price(String promote_price) {
		this.promote_price = promote_price;
	}








	public String getImg() {
		return img;
	}








	public void setImg(String img) {
		this.img = img;
	}








	public String getGoods_type() {
		return goods_type;
	}








	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}








	public String getApp_cut_price() {
		return app_cut_price;
	}








	public void setApp_cut_price(String app_cut_price) {
		this.app_cut_price = app_cut_price;
	}








	public String getApp_cut_price_desc() {
		return app_cut_price_desc;
	}








	public void setApp_cut_price_desc(String app_cut_price_desc) {
		this.app_cut_price_desc = app_cut_price_desc;
	}








	@Override
	public String toString() {
		return "LocalData [goods_id=" + goods_id + ", name=" + name
				+ ", marcket_price=" + market_price + ", shop_private="
				+ shop_price + ", img=" + img + "]";
	}

	
}
