package com.worldtrival.bean;

import java.util.List;

public class HomeSearchData {
	private String hot_keyworld;
	private List<Recommend> list;
	public HomeSearchData(String hot_keyworld, List<Recommend> list) {
		super();
		this.hot_keyworld = hot_keyworld;
		this.list = list;
	}
	public HomeSearchData() {
		super();
	}
	public String getHot_keyworld() {
		return hot_keyworld;
	}
	public void setHot_keyworld(String hot_keyworld) {
		this.hot_keyworld = hot_keyworld;
	}
	public List<Recommend> getList() {
		return list;
	}
	public void setList(List<Recommend> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "HomeSearchData [hot_keyworld=" + hot_keyworld + ", list="
				+ list + "]";
	}
	
	
}
