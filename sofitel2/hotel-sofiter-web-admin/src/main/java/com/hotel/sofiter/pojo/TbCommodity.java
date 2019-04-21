package com.hotel.sofiter.pojo;

import io.swagger.annotations.ApiModelProperty;

public class TbCommodity {
	@ApiModelProperty("ID")
	private Integer id;
	@ApiModelProperty("商品类别")
	private Integer commodityTypeID;
	@ApiModelProperty("计量单位")
	private Integer uOMID;
	@ApiModelProperty("商品名称")
	private String commodityName;
	@ApiModelProperty("商品价格")
	private String salePrice;

	//宽展字段
	@ApiModelProperty("商品类别名称")
	private String commodityTypeName;  //商品类别名称
	@ApiModelProperty("计量单位名称")
	private String uOMName;  //计量单位名称



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommodityTypeID() {
		return commodityTypeID;
	}

	public void setCommodityTypeID(Integer commodityTypeID) {
		this.commodityTypeID = commodityTypeID;
	}

	public Integer getuOMID() {
		return uOMID;
	}

	public void setuOMID(Integer uOMID) {
		this.uOMID = uOMID;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getCommodityTypeName() {
		return commodityTypeName;
	}

	public void setCommodityTypeName(String commodityTypeName) {
		this.commodityTypeName = commodityTypeName;
	}

	public String getuOMName() {
		return uOMName;
	}

	public void setuOMName(String uOMName) {
		this.uOMName = uOMName;
	}

}
