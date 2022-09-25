package com.auction.model;


import java.time.LocalDate;
import java.util.*;

public class User {
private int uId;//unique id
private double amtInWallet;
private String name,email,ph_Number,userName,password,address,type;
private LocalDate dob;
public User() {
	
}
public User(int uId) {
	this.uId = uId; 
}
public User(int uId, double amtInWallet, String name, String email, String ph_Number, String userName, String password,
		String address, String type, LocalDate dob) {
	super();
	this.uId = uId;
	this.amtInWallet = amtInWallet;
	this.name = name;
	this.email = email;
	this.ph_Number = ph_Number;
	this.userName = userName;
	this.password = password;
	this.address = address;
	this.type = type;
	this.dob = dob;
}
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public double getAmtInWallet() {
	return amtInWallet;
}
public void setAmtInWallet(double amtInWallet) {
	this.amtInWallet = amtInWallet;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPh_Number() {
	return ph_Number;
}
public void setPh_Number(String ph_Number) {
	this.ph_Number = ph_Number;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
@Override
public int hashCode() {
	return Objects.hash(address, amtInWallet, dob, email, name, password, ph_Number, type, uId, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(address, other.address)
			&& Double.doubleToLongBits(amtInWallet) == Double.doubleToLongBits(other.amtInWallet)
			&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email) && Objects.equals(name, other.name)
			&& Objects.equals(password, other.password) && Objects.equals(ph_Number, other.ph_Number)
			&& Objects.equals(type, other.type) && uId == other.uId && Objects.equals(userName, other.userName);
}
@Override
public String toString() {
	return "User [uId=" + uId + ", amtInWallet=" + amtInWallet + ", name=" + name + ", email=" + email + ", ph_Number="
			+ ph_Number + ", userName=" + userName + ", password=" + password + ", address=" + address + ", type="
			+ type + ", dob=" + dob + "]";
}



}

