package com.auction.bo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.TreeSet;

import com.auction.model.Product;

public interface AuctionService {
	//implements end auction
	void addUser(int uId, double amtInWallet, String name, String email, String ph_Number, String userName, String password,
			String address, String type, LocalDate dob) throws SQLException;
	void addCategory(int categoryUniqueId, String name, String description) throws SQLException;
	//first page 
	int addLogin(String userName,String password) throws SQLException;
	TreeSet<Product> displayProducts() throws SQLException;
	//seller page(basic info + addproduct)
	void sellerInfo() throws SQLException;
	void displaySalesProduct() throws SQLException;
	void addProduct(String name,String category,String description,double actualPrice,int quantity,String img);
	//String generateId(String name);
	//seller page(schedule auction)
	public void ScheduleAuction(String name,double minBidValue,Date start,Date end) throws SQLException;

	
	//buyer
	void displayBuyerDetails(int bId)throws SQLException;//1.print products bought by product id 2.products open for auction

	void auctionResult(String name,int uId) throws SQLException;
}

