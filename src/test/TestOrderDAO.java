package test;


import java.time.LocalDate;
import java.util.List;

import dao.OrderDAO;
import model.Order;


public class TestOrderDAO {
	

	 public static void main(String[] args) throws Exception {
         LocalDate L= LocalDate.parse("2017-06-13");
			
			Order user = new Order();
			user.setId(1);
	        user.setUser_id(2);
	        user.setBook_id(3);
	        user.setQuantity(5);
	        user.setStatus("ordered");
	        user.setOrder_date(L); 
	        OrderDAO userDAO = new OrderDAO();
	       // userDAO.addorder(user);
	        List<Order> orderlist = userDAO.listorder();
	 
	        System.out.println(orderlist);

			for (Order b : orderlist) {
				System.out.println(b);
			}

	
}

	
	
	

}
