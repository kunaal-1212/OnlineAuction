package com.auction.bo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import com.auction.doa.AuctionDAO;
import com.auction.doa.AuctionDAOImpl;
import com.auction.model.Bid;
import com.auction.model.Product;
import com.auction.model.Seller;


public class AuctionServiceImpl implements AuctionService {
	//List<User> user = new ArrayList();
	private AuctionDAO auctionDAO;
	static int count=100;
	public AuctionServiceImpl() {
		auctionDAO = new AuctionDAOImpl();
	}
	//register details to be taken from webpage and added in db;
	@Override
	public void addUser(int uId, double amtInWallet, String name, String email, String ph_Number, String userName,
			String password, String address, String type, LocalDate dob) throws SQLException {
		auctionDAO.addUser(uId, amtInWallet, name, email, ph_Number, userName, password, address, type, dob);
	}

	@Override
	public void addCategory(int categoryUniqueId, String name, String description) throws SQLException{
		auctionDAO.addCategory(categoryUniqueId, name, description) ;
	}

	@Override
	public int addLogin(String userName, String password) throws SQLException{
		int flag = auctionDAO.addLogin(userName, password);
		return flag;
		//use this flag tag to print alert message on webpage
		
		//display on web page;
		
	}

	@Override
	public TreeSet<Product> displayProducts() throws SQLException {
		TreeSet<Product> p1 = new TreeSet<>();
		p1=auctionDAO.displayProducts();
		//webpage mai display karenge
		return p1;
	}

	@Override
	public void sellerInfo() throws SQLException{
		TreeSet<Seller> s1 = new TreeSet<>();

		s1=auctionDAO.sellerInfo();
		//webpage mai display karenge

	}

	@Override
	public void displaySalesProduct() throws SQLException {
		//db se data retrive and display on the webpage
		Bid b1;
		b1 = auctionDAO.displaySalesProduct();
		
	}

	@Override
	public void addProduct(String name, String category, String description, double actualPrice, int quantity,
			String img) {
		// TODO Auto-generated method stub
		
	}

	//@Override
//	public String generateId(String name) {
//		String str = name.substring(0,3) + count  ;
//		count++;
////		set product id in the table while seaching in db table by product name and with same product name add seller id
//		return str;
//		
//		
//	}

	@Override
	public void displayBuyerDetails(int bId) throws SQLException{
		List<String> name = new ArrayList<>();
		name = auctionDAO.displayBuyerDetails(bId);
		
	}

	
	@Override
	public void ScheduleAuction(String name, double minBidValue, Date start, Date end) throws SQLException {
		auctionDAO.ScheduleAuction(name, minBidValue, start, end);
	}
	@Override
	public void auctionResult(String name, int uId) throws SQLException {
		auctionDAO.auctionResult(name, uId);
	}

}

