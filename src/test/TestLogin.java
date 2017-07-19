package test;

import dao.UserDAO;
import model.user;

public class TestLogin {

	   public static void main(String[] args) throws Exception {

			
			user user = new user();
	        user.setName("abc");
	        user.setEmail_id("sdassdsad@gmail.com");
	        user.setPassword("pass");
	  String email_id="nandhinijayabal1@gmail.com";
	  String password1="nandy";
	  
	        UserDAO userDAO = new UserDAO();
	       user u = userDAO.login(email_id,password1);
	        System.out.println(u);

	
	

	   }
}


