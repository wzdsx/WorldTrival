package com.worldtrival.bean;

import java.util.List;

public class ContinentBean {
	private List<SearchContinent> list;

	public ContinentBean(List<SearchContinent> list) {
		super();
		this.list = list;
	}
	
	public ContinentBean() {
		super();
	}

	public List<SearchContinent> getList() {
		return list;
	}

	public void setList(List<SearchContinent> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ContinentBean [list=" + list + "]";
	}
	
}
