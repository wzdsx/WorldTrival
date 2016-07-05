package com.worldtrival.message;

import com.worldtrival.base.BaseHomeMessage;

public class HomeMessageSearch extends BaseHomeMessage {
	private int image;
	private String text1,text2,text3;
	private boolean flag;
	public HomeMessageSearch(int type, int image, String text1, String text2,
			String text3,boolean flag) {
		super(type);
		this.image = image;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.flag = flag;
	}
	


	public int getImage() {
		return image;
	}



	public void setImage(int image) {
		this.image = image;
	}



	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getText3() {
		return text3;
	}
	public void setText3(String text3) {
		this.text3 = text3;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
