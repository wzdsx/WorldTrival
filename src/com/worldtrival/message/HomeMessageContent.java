package com.worldtrival.message;

import com.worldtrival.base.BaseHomeMessage;

public class HomeMessageContent extends BaseHomeMessage {
	private int image1,image2,image3,image4,image5,image6,image7,image8;
	private String text1,text2,text3;
	public HomeMessageContent(int type, int image1, int image2, int image3,
			int image4, int image5, int image6, int image7, int image8,
			String text1, String text2, String text3) {
		super(type);
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.image7 = image7;
		this.image8 = image8;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}
	public int getImage1() {
		return image1;
	}
	public void setImage1(int image1) {
		this.image1 = image1;
	}
	public int getImage2() {
		return image2;
	}
	public void setImage2(int image2) {
		this.image2 = image2;
	}
	public int getImage3() {
		return image3;
	}
	public void setImage3(int image3) {
		this.image3 = image3;
	}
	public int getImage4() {
		return image4;
	}
	public void setImage4(int image4) {
		this.image4 = image4;
	}
	public int getImage5() {
		return image5;
	}
	public void setImage5(int image5) {
		this.image5 = image5;
	}
	public int getImage6() {
		return image6;
	}
	public void setImage6(int image6) {
		this.image6 = image6;
	}
	public int getImage7() {
		return image7;
	}
	public void setImage7(int image7) {
		this.image7 = image7;
	}
	public int getImage8() {
		return image8;
	}
	public void setImage8(int image8) {
		this.image8 = image8;
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
	
}
