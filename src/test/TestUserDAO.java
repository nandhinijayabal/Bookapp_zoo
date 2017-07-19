package test;

import dao.UserDAO;
import model.user;

public class TestUserDAO {

		
	   public static void main(String[] args) throws Exception {

			
			user user = new user();
	        user.setName("abc");
	        user.setEmail_id("sdassdsad@gmail.com");
	        user.setPassword("pass");
	 
	        UserDAO userDAO = new UserDAO();
	        userDAO.register(user);
 

	}

}
