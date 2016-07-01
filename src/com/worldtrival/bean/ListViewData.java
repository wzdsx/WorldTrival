package com.worldtrival.bean;

import java.util.ArrayList;

import com.worldtrival.base.BaseHomeMessage;

public class ListViewData {
	private String title,text;
	private ArrayList<GoodList> list;
	public ListViewData() {
		super();
	}
	
	
	
	public ListViewData( String title, String text,
			ArrayList<GoodList> list) {
		super();
		this.title = title;
		this.text = text;
		this.list = list;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<GoodList> getList() {
		return list;
	}
	public void setList(ArrayList<GoodList> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ListViewData [title=" + title + ", text=" + text + ", list="
				+ list + "]";
	}
	
}
