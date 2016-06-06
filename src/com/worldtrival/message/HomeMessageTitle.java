package com.worldtrival.message;

import com.worldtrival.base.BaseHomeMessage;

public class HomeMessageTitle extends BaseHomeMessage {
	private int image1,image2,image3;

	public HomeMessageTitle(int type, int image1, int image2, int image3) {
		super(type);
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
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
	
}
