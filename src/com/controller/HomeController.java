package com.controller;

	import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

import dao.BookDAO;
import dao.OrderDAO;
import dao.UserDAO;
import model.Book;
import model.Order;
import model.user;

	@Controller
	@RequestMapping("/")
	public class HomeController {
		
		@RequestMapping( method = RequestMethod.GET)
		public String index() {
			System.out.println("index");
			return "index";
		}
		
		@RequestMapping(value="/home" , method = RequestMethod.GET)
		public String home(ModelMap modelMap) {
			System.out.println("Home");
			modelMap.addAttribute("MESSAGE", "Success");
			return "home";
		}
	
@GetMapping("/addbookservlet")	

public String addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();
	out.println("addbookservlet");
	
	
	
	String name = request.getParameter("name");
	String price=request.getParameter("price");
	String author_id=request.getParameter("author_id");
	String pub_date=request.getParameter("pub_date");

	out.println("name="+ name);
	out.println("price="+ price);
	out.println("author_id="+ author_id);
	out.println("pub_date="+ pub_date);
	
	int price1 = Integer.parseInt(price);
	LocalDate pub_date1 = LocalDate.parse(pub_date);
  int author_id1 = Integer.parseInt(author_id);

   BookDAO bookDAO =new BookDAO();
	
	Book book = new Book();
	book.setName(name);
	book.setPrice(price1);
	book.setAuthor_id(author_id1);
	book.setPub_date(pub_date1);
    out.println(book);
    
    
    try {
		bookDAO.addbook(book);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
   // response.sendRedirect("addbook.jsp");
    return "redirect:addbook";
}

	@GetMapping("/LogoutServlet")
	
	public String Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		//response.sendRedirect("login.html");
	    return "redirect:login";

		
	}
	@GetMapping("/OrderBookServlet")

	public String OrderBookServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("orderbookservlet");

		
		String userid =request.getParameter("userid");
		String bookid =request.getParameter("bookid");
		String quantity =request.getParameter("quantity");
		
		out.println("User_id="+ userid);
		out.println("Book_id="+ bookid);
		out.println("quantity="+ quantity);
		
		int userid1 = Integer.parseInt(userid);
		int bookid1 = Integer.parseInt(bookid);
		int quantity1 = Integer.parseInt(quantity);
		
		  OrderDAO orderDAO =new OrderDAO();
			
			Order order = new Order();
			order.setUser_id(userid1);
			order.setBook_id(bookid1);
			order.setQuantity(quantity1);
			order.setOrder_date(LocalDate.now());
			order.setStatus("ordered");
	        out.println(order);

	        
	        try {
				orderDAO.addorder(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	       // response.sendRedirect("listorder.jsp");
	        return "redirect:addbook";
	        
	        
	}	        
	@GetMapping("/RegisterUserServlet")
	
	public String RegisterUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("RegisterUserServlet");
		
		String name =request.getParameter("name");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		
		out.println("Name="+ name);
		out.println("email="+ email);
		out.println("password="+ password);

		UserDAO userDAO =new UserDAO();
		
		user user = new user();
		user.setName(name);
		user.setEmail_id(email);
		user.setPassword(password);
 out.println(user);
		
		try {
			userDAO.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.sendRedirect("success.html");
		
	    return "redirect:success";

	}
	
	
	@GetMapping("/loginServlet")
	
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		out.println("loginServlet");
		
		
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		
		
		out.println("email="+ email);
		out.println("password="+ password);

		UserDAO userDAO =new UserDAO();
	
		
		
		try {
			user u = userDAO.login(email,password);
			out.println(u);
			
			if(u==null)
			{
				//response.sendRedirect("login.html");
			return"redirect:login.html";
			}
			else
				
				{
				
				HttpSession session = request.getSession();
			    session.setAttribute("Logged_In_User", u);

				//response.sendRedirect("listbooks.jsp");
				return"redirect:listbooks.jsp";

			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return null;
	
	}

	
}
