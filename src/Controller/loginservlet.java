package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.user;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

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
				response.sendRedirect("login.html");
			
			}
			else
				
				{
				
				HttpSession session = request.getSession();
			    session.setAttribute("Logged_In_User", u);

				response.sendRedirect("listbooks.jsp");
			//	response.sendRedirect("success.html");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	
}

