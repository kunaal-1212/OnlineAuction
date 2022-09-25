package com.auction.model;

import java.util.Date;
import java.util.Objects;

public class Bid extends Product {
	private int bidUniqueId,count;
	private double bidValue;

	String status;
	
	
	public Bid(String productName, double value, int count, Date end) {
		super(productName, end);
		this.count = count;
		bidValue = value;
	}

	public Bid() {
		// super();
	}

	public Bid(int uId, int productUniqueId, int bidUniqueId, double bidValue, String status) {
		super(uId, productUniqueId);
		this.bidUniqueId = bidUniqueId;
		this.bidValue = bidValue;
		this.status = status;
	}

	

	public int getBidUniqueId() {
		return bidUniqueId;
	}

	public void setBidUniqueId(int bidUniqueId) {
		this.bidUniqueId = bidUniqueId;
	}

	public double getBidValue() {
		return bidValue;
	}

	public void setBidValue(double bidValue) {
		this.bidValue = bidValue;
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
		result = prime * result + Objects.hash(bidUniqueId, bidValue, status);
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
		Bid other = (Bid) obj;
		return bidUniqueId == other.bidUniqueId
				&& Double.doubleToLongBits(bidValue) == Double.doubleToLongBits(other.bidValue)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Bid [bidUniqueId=" + bidUniqueId + ", bidValue=" + bidValue + ", status=" + status + "]";
	}

}
