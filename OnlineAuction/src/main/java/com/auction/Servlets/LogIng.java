package com.auction.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auction.bo.AuctionService;
import com.auction.bo.AuctionServiceImpl;

/**
 * Servlet implementation class LogIng
 */
@WebServlet("/LogIng")
public class LogIng extends HttpServlet {
	AuctionService auctionService = new AuctionServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String id = request.getParameter("userName");
		String code = request.getParameter("password");
		try {
			int flag = auctionService.addLogin(id, code);
			if(flag ==1) {
				// if log in credentials matched then call a html file to print login successful;
				request.getRequestDispatcher("AfterLogIn.jsp");//afterlogin file name pls change later
			}
			else {
				request.getRequestDispatcher("error.jsp").forward(request, response);//afterlogin file name pls change later
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
//@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
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
}
