package com.auction.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
//last log in time and date refer later
public class Seller {
	//private int sellerId;
	private String name,email,phNumber;
	private Date loginDate;
	private Date lastLoginDate;
	private static int flag=0;
	
//	public Seller(int sellerId, String name, String email, String phNumber, Date loginDate, Date lastLoginDate) {
//		super();
//		this.sellerId = sellerId;
//		this.name = name;
//		this.email = email;
//		this.phNumber = phNumber;
//		this.loginDate = loginDate;
//		this.lastLoginDate = lastLoginDate;
//	}
	public Seller(String name, String email, String phNumber, Date loginDate, Date lastLoginDate) {
		super();
		this.name = name;
		this.email = email;
		this.phNumber = phNumber;
		this.loginDate = loginDate;
		this.lastLoginDate = lastLoginDate;
	}
	
//	public int getSellerId() {
//		return sellerId;
//	}
//	public void setSellerId(int sellerId) {
//		this.sellerId = sellerId;
//	}
////	public String getName() {
//		return name;
//	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public static int getFlag() {
		return flag;
	}
	public static void setFlag(int flag) {
		Seller.flag = flag;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, lastLoginDate, loginDate, name, phNumber);// sellerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(email, other.email) && Objects.equals(lastLoginDate, other.lastLoginDate)
				&& Objects.equals(loginDate, other.loginDate) && Objects.equals(name, other.name)
				&& Objects.equals(phNumber, other.phNumber) ;//&& sellerId == other.sellerId;
	}
	@Override
	public String toString() {
		return "[ name=" + name + ", email=" + email + ", phNumber=" + phNumber
				+ ", loginDate=" + loginDate + ", lastLoginDate=" + lastLoginDate + "]";
	}
			
}
