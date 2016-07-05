package com.worldtrival.bean;

import java.util.List;



public class LocalData {

	
	private List<LocalGoodsBranch> goods;
	private Localcity city;
	public List<LocalGoodsBranch> getGoods() {
		return goods;
	}
	public void setGoods(List<LocalGoodsBranch> goods) {
		this.goods = goods;
	}
	public Localcity getCity() {
		return city;
	}
	public void setCity(Localcity city) {
		this.city = city;
	}
	
}
