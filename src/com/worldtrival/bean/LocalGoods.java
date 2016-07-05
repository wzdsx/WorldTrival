package com.worldtrival.bean;

import java.util.List;

public class LocalGoods {

	private List<LocalGoodsBranch> branch;

	public List<LocalGoodsBranch> getBranch() {
		return branch;
	}

	public void setBranch(List<LocalGoodsBranch> branch) {
		this.branch = branch;
	}

	public LocalGoods(List<LocalGoodsBranch> branch) {
		super();
		this.branch = branch;
	}
	
	
}
