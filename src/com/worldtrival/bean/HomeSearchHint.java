package com.worldtrival.bean;

import java.util.List;

public class HomeSearchHint {
	private Status status;
	private List<HintData> list;
	public HomeSearchHint(Status status, List<HintData> list) {
		super();
		this.status = status;
		this.list = list;
	}
	public HomeSearchHint() {
		super();
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<HintData> getList() {
		return list;
	}
	public void setList(List<HintData> list) {
		this.list = list;
	}
	
}
