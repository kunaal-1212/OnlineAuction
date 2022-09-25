package com.auction.doa;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import com.auction.model.Bid;
import com.auction.model.Product;
import com.auction.model.Seller;

public interface AuctionDAO {
	void addUser(int uId, double amtInWallet, String name, String email, String ph_Number, String userName,
			String password, String address, String type, LocalDate dob) throws SQLException;

	void addCategory(int categoryUniqueId, String name, String description) throws SQLException;

	// first page
	int addLogin(String userName,String password) throws SQLException;
	TreeSet<Product> displayProducts() throws SQLException;

	// seller page(basic info + addproduct)
	TreeSet<Seller> sellerInfo() throws SQLException;

	Bid displaySalesProduct() throws SQLException;

	void addProduct(String name, String category, String description, double actualPrice, int quantity, String img);
	// String generateId(String name);
	// seller page(schedule auction)
	//to take details from seller to start auction
	public void ScheduleAuction(String name,double minBidValue,Date start,Date end) throws SQLException;
	// buyer
	List<String>displayBuyerDetails(int bId)throws SQLException;// 1.print products bought by product id 2.products open for auction
	void auctionResult(String name,int uId) throws SQLException;
}
