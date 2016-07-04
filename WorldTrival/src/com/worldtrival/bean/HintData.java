package com.worldtrival.bean;
/*
 * 输入搜索
 */
public class HintData {
	private String destId,destName,goodsId,goodsName,shopPrice,catName;

	public HintData(String destId, String destName, String goodsId,
			String goodsName, String shopPrice, String catName) {
		super();
		this.destId = destId;
		this.destName = destName;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.shopPrice = shopPrice;
		this.catName = catName;
	}

	public HintData() {
		super();
	}

	public String getDestId() {
		return destId;
	}

	public void setDestId(String destId) {
		this.destId = destId;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(String shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
}
