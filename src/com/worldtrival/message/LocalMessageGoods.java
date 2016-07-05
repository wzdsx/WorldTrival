package com.worldtrival.message;

import com.worldtrival.base.BaseHomeMessage;

public class LocalMessageGoods extends BaseHomeMessage {
	

	private int image;

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public LocalMessageGoods(int type, int image) {
		super(type);
		this.image = image;
	}

	

}
