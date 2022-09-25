package com.auction.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import com.auction.model.Bid;
import com.auction.model.Category;
import com.auction.model.Product;
import com.auction.model.Seller;
import com.auction.model.User;

public class AuctionDAOImpl implements AuctionDAO {
	static int count = 100;
	Connection connection;
	User user;
	Category category;
	Product product;
	Bid bid;

	// registration details added to db via user class
	@Override
	public void addUser(int uId, double amtInWallet, String name, String email, String ph_Number, String userName,
			String password, String address, String type, LocalDate dob) throws SQLException {
		// take inputs from the web page;
		user = new User(uId, amtInWallet, name, email, ph_Number, userName, password, address, type, dob);
		try {
			connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
			String cmd = "INSERT INTO USER values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(cmd);
			preparedStatement.setInt(1, uId);
			preparedStatement.setDouble(2, amtInWallet);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, ph_Number);
			preparedStatement.setString(6, userName);
			preparedStatement.setString(7, password);
			preparedStatement.setString(8, address);
			preparedStatement.setString(9, type);
			preparedStatement.setDate(10,dob);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// adding category
	@Override
	public void addCategory(int categoryUniqueId, String name, String description) throws SQLException {
		category = new Category(categoryUniqueId, name, description);
		try {
			connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
			String cmd = "INSERT INTO CATEGORY values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(cmd);
			preparedStatement.setInt(1, categoryUniqueId);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, description);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

//db se data retrive and check her if login successful;
//	@Override
	public int addLogin(String userName, String password) throws SQLException {
		connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * from USER";
		ResultSet rs = statement.executeQuery(cmd);
		while (rs.next()) {
			String name = rs.getString("userName");
			String code = rs.getString("password");
			if (!(userName.equals(name)) && !(password.equals(code))) {
				// printing error in login credentials

				return 0;
			}
		}
		return 1;

	}

	@Override
	public TreeSet<Product> displayProducts() throws SQLException {
		TreeSet<Product> pFinal = new TreeSet<Product>();
		connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * from PRODUCT";
		ResultSet rs = statement.executeQuery(cmd);
		// table product has filds (productUniqueId,uId,quantity,actualPrice,
		// minBidValue,
		// soldPrice,bidStartDate,bidEndDate,name, category, description, img, status)

		while (rs.next()) {
			int pUId = rs.getInt("productUniqueId");
			int uniqueId = rs.getInt("uId");
			int quan = rs.getInt("quantity");
			double cost = rs.getDouble("actualPrice");
			double minCost = rs.getDouble("minBidValue");
			double soldCost = rs.getDouble("soldPrice");
			Date start = rs.getDate("bidStartDate");
			Date end = rs.getDate("bidEndDate");
			String productName = rs.getString("name");
			String type = rs.getString("category");
			String about = rs.getString("description");
			String image = rs.getString("img");
			String stt = rs.getString("status");

			Product p = new Product(uniqueId, pUId, quan, cost, minCost, soldCost, start, end, productName, type, about,
					image, stt);
			pFinal.add(p);
		}
		return pFinal;

	}

	@Override
	public TreeSet<Seller> sellerInfo() throws SQLException {
		// db se data retrive and display on the webpage
		TreeSet<Seller> sFinal = new TreeSet<Seller>();
		connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * from SELLER";
		ResultSet rs = statement.executeQuery(cmd);

		// public Seller(String name, String email, String phNumber, LocalDateTime
		// loginDateTime) {

		while (rs.next()) {
			String sellerName = rs.getString("name");
			String mail = rs.getString("email");
			String contactNumber = rs.getString("phNumber");
			Date start = rs.getDate("loginDateTime");
			Date end = rs.getDate("lastDateTime");
			//String str = name.substring(0,3) + count  ;
		//count++;
			//set product id in the table while seaching in db table by product name and with same product name add seller id
			
			Seller sell = new Seller(sellerName, mail, contactNumber, start, end);
			sFinal.add(sell);

		}
		return sFinal;

	}

	@Override
	// display products for open in auction
	public Bid displaySalesProduct() throws SQLException {
		// db se data retrive and display on the webpage
		// TreeSet<Bid> pFinal1 = new TreeSet<Bid>();
		Bid b = new Bid();
		int count = 0;
		connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * from BID";
		ResultSet rs = statement.executeQuery(cmd);
		// table product has fields (productUniqueId,uId,quantity,actualPrice,
		// minBidValue,
		// soldPrice,bidStartDate,bidEndDate,name, category, description, img, status)
		double max = 0.0;
		List<Double> currentBid = new ArrayList<>();
		while (rs.next()) {
			double value = rs.getDouble("bidValue");
			currentBid.add(value);
			count++;

		}
		// Entry<String,Double> ent = currentBid.firstEntry();
		Iterator<Double> itr = currentBid.iterator();
		double cost;
		while (itr.hasNext()) {
			cost = itr.next();
			if (max < cost)
				max = cost;
		}
		String cmds = "SELECT * from BID";
		ResultSet result = statement.executeQuery(cmds);
		while (result.next()) {
			Date end = rs.getDate("bidEndDate");
			String productName = rs.getString("name");
			double value = rs.getDouble("bidValue");
			if (value == max) {
				b = new Bid(productName, value, count, end);
				try {
					connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
					String cmd1 = "INSERT INTO BID values(?,?,?,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(cmd1);
					preparedStatement.setString(1, productName);
					preparedStatement.setDouble(2, value);
					preparedStatement.setInt(3, count);
					preparedStatement.setDate(4, (java.sql.Date) end);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

			}
		}

		return b;

	}

	@Override
	public void addProduct(String name, String category, String description, double actualPrice, int quantity,
			String img) {
		product = new Product(quantity, actualPrice, name, category, description, img);
		try {
			connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
			String cmd = "INSERT INTO AVAILABLE values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(cmd);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setDouble(2, actualPrice);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, category);
			preparedStatement.setString(5, description);
			preparedStatement.setString(6, img);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

//	@Override
//	public String generateId(String name) {
//		 
//		String str = name.substring(0,3) + count  ;
//		//set product id in the table while seaching in db table by product name and with same product name add seller id
//		return str;
//	}

	// display buyer bought product details
	@Override
	public List<String> displayBuyerDetails(int bId ) throws SQLException {
		// db se data retrive and display on the webpages
		List<String> names = new ArrayList<>();
		connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * from SOLD";
		ResultSet rs = statement.executeQuery(cmd);
		while(rs.next()) {
			int buyerId = rs.getInt("uId");
			String name = rs.getString("name");
			if(buyerId == bId) {
				names.add(name);
			}
		}
		return names;

	}
//auction ending

	@Override
	public void ScheduleAuction(String name, double minBidValue, Date start, Date end) throws SQLException {
		// db se data retrive karke check if its type="seller" and matches with current
		// check which table to add once
		Product sellerInput = new Product(name, minBidValue, start, end);
		try {
			connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
			String cmd = "INSERT INTO SELLERAUCTIONSTART values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(cmd);
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, minBidValue);
			preparedStatement.setDate(3, (java.sql.Date) start);
			preparedStatement.setDate(4, (java.sql.Date) end);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void auctionResult(String name, int uId) throws SQLException {
		// main take is to retrive seller id via Productname ,transfer money,reduce
		// quantity
		// retriving seller id
		int sellerId = 0, quan = 0;
		double price = 0.0;
		double SellerwalletMoney = 0.0, buyerWalletMoney = 0.0;
		connection = DriverManager.getConnection("jdbc:derby:AuctionDB");
		Statement statement = connection.createStatement();
		String cmd = "SELECT * from PRODUCT";
		ResultSet rs = statement.executeQuery(cmd);
		// table product has filds (productUniqueId,uId,quantity,actualPrice,
		// minBidValue,
		// soldPrice,bidStartDate,bidEndDate,name, category, description, img, status)

		while (rs.next()) {
			String productName = rs.getString("name");
			if (productName.equals(name)) {
				sellerId = rs.getInt("uId");
				String cmd1 = "SELECT * FROM USER";
				ResultSet result = statement.executeQuery(cmd1);
				while (result.next()) {
					int id = result.getInt("uId");
					if (id == sellerId)
						SellerwalletMoney = result.getDouble("amtInWallet");
					else if (id == uId)
						buyerWalletMoney = result.getDouble("amtInWallet");
				}
			}

		}
		// transfer money
		String cmd2 = "SELECT * FROM BID";
		ResultSet resultSet = statement.executeQuery(cmd2);

		while (resultSet.next()) {
			price = resultSet.getDouble("value");
		}

		SellerwalletMoney += price;
		buyerWalletMoney -= price;
		// update these values back to table
		String query = "UPDATE TABLE USER SET amtInWallet=? WHERE uId = ?";
		String query1 = "UPDATE TABLE USER SET amtInWallet=? WHERE uId = ?";

		PreparedStatement stmt1 = connection.prepareStatement(query);
		stmt1.setDouble(2, SellerwalletMoney);
		stmt1.setInt(1, sellerId);
		stmt1.executeUpdate();

		PreparedStatement stmt2 = connection.prepareStatement(query1);
		stmt2.setDouble(2, buyerWalletMoney);
		stmt2.setInt(1, uId);
		stmt2.executeUpdate();

		//reduce Quantity
		String cmd3 = "SELECT * FROM PROUCT";
		ResultSet resultSet1 = statement.executeQuery(cmd3);
		
		while (resultSet1.next()) {
			quan = resultSet.getInt("quantity");
		}
		quan -= 1;
		String cmd4 = "UPDATE FROM PRODUCT SET quantity=? WHERE NAME=?";
		PreparedStatement stmt3 = connection.prepareStatement(cmd4);
		stmt3.setInt(3,quan);
		stmt3.executeUpdate();
		
		//adding list of products ,seller id and buyer id;
		String cmd5 = "INSERT INTO SOLD(uId,sellerId,name) VALUES(?,?,?)";
		PreparedStatement stmt4 = connection.prepareStatement(cmd5);
		stmt4.setInt(1,uId);
		stmt4.setInt(2,sellerId);
		stmt4.setString(3,name );

	}
}
