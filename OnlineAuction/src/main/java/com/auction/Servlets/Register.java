package com.auction.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auction.bo.AuctionService;
import com.auction.bo.AuctionServiceImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	AuctionService auctionService = new AuctionServiceImpl();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//in brackets add the name;
		String id = request.getParameter("uId");
		String Username = request.getParameter("name");
		String bornDate = request.getParameter("dob");
		String mail = request.getParameter("email");
		String contactNumber = request.getParameter("phNumber");
		String logIn = request.getParameter("userName");
		String code = request.getParameter("password");
		String confirmCode = request.getParameter("confirmPassword");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		String money = request.getParameter("amountInWallet");
		
		int ids = Integer.parseInt(id);
		double moneys = Double.parseDouble(money);
		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		  

    LocalDate localDate = LocalDate.parse(bornDate, formatter_1);
		//public void addUser(int uId, double amtInWallet, String name, String email, String ph_Number, String userName,
		//String password, String address, String type, Date dob) throws SQLException {
			
		try {
			auctionService.addUser(ids,moneys,Username, mail, contactNumber, logIn, code, address, type,localDate);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
}

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
