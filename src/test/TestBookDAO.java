package test;


import java.time.LocalDate;

import dao.BookDAO;
import model.Book;

public class TestBookDAO {



		 public static void main(String[] args) throws Exception {
              LocalDate L= LocalDate.parse("2017-06-08");
				
				Book user = new Book();
		        user.setName("java");
		        user.setPrice(500);
		        user.setPub_date(L);
		        user.setAuthor_id(1);
		 
		        BookDAO userDAO = new BookDAO();
		        //userDAO.addbook(user);
		        userDAO.listbook();
		 

		
	}

}
