package com.auction.model;

import java.util.Date;
import java.util.Objects;
//add comparator to sort the data
public class Product extends User {
	private int productUniqueId, quantity;
	private double actualPrice, minBidValue, soldPrice;
	private Date bidStartDate = new Date();
	private Date bidEndDate = new Date();
	private String name, category, description, img, status;

	public Product(int sellerUniqueId, int productUniqueId) {
		super(sellerUniqueId);
		this.productUniqueId = productUniqueId;
	}

	public Product(int uId, int productUniqueId, int quantity, double actualPrice, double minBidValue, double soldPrice,
			Date bidStartDate, Date bidEndDate, String name, String category, String description, String img,
			String status) {
		super(uId);
		this.productUniqueId = productUniqueId;
		this.quantity = quantity;
		this.actualPrice = actualPrice;
		this.minBidValue = minBidValue;
		this.soldPrice = soldPrice;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.name = name;
		this.category = category;
		this.description = description;
		this.img = img;
		this.status = status;
	}
	

	public Product(int quantity, double actualPrice, String name, String category, String description, String img) {
		super();
		this.quantity = quantity;
		this.actualPrice = actualPrice;
		this.name = name;
		this.category = category;
		this.description = description;
		this.img = img;
	}
	public Product() {
		//super();
	}
	public Product(String productName, Date end) {
		super();
		name = productName;
		bidEndDate = end;
	}

	public Product(String name, double price,Date start, Date end) {
		super();
		this.name = name;
		minBidValue = price;
		bidStartDate = start;
		bidEndDate = end;
	}

	public int getProductUniqueId() {
		return productUniqueId;
	}

	public void setProductUniqueId(int productUniqueId) {
		this.productUniqueId = productUniqueId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public double getMinBidValue() {
		return minBidValue;
	}

	public void setMinBidValue(double minBidValue) {
		this.minBidValue = minBidValue;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(actualPrice, bidEndDate, bidStartDate, category, description, img,
				minBidValue, name, productUniqueId, quantity, soldPrice, status);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Double.doubleToLongBits(actualPrice) == Double.doubleToLongBits(other.actualPrice)
				&& Objects.equals(bidEndDate, other.bidEndDate) && Objects.equals(bidStartDate, other.bidStartDate)
				&& Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(img, other.img)
				&& Double.doubleToLongBits(minBidValue) == Double.doubleToLongBits(other.minBidValue)
				&& Objects.equals(name, other.name) && productUniqueId == other.productUniqueId
				&& quantity == other.quantity
				&& Double.doubleToLongBits(soldPrice) == Double.doubleToLongBits(other.soldPrice)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Product [productUniqueId=" + productUniqueId + ", quantity=" + quantity + ", actualPrice=" + actualPrice
				+ ", minBidValue=" + minBidValue + ", soldPrice=" + soldPrice + ", bidStartDate=" + bidStartDate
				+ ", bidEndDate=" + bidEndDate + ", name=" + name + ", category=" + category + ", description="
				+ description + ", img=" + img + ", status=" + status + "]";
	}

}
