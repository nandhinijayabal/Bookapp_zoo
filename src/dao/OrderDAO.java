package dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import util.ConnectionUtil;


public class OrderDAO {


	public void addorder(Order user) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into orders(user_id,book_id,quantity,status,order_date) values(?,?,?,?,?)";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setInt(1, user.getUser_id());
		pst.setInt(2, user.getBook_id());
		pst.setInt(3, user.getQuantity());
		pst.setString(4, user.getStatus());
		pst.setDate(5, Date.valueOf(user.getOrdered_date()));
		
		
	

		int rows = pst.executeUpdate();
		System.out.println("no of rows" + rows);

	}
	
	public List<Order> listorderold() throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,user_id,book_id,quantity,status,order_date from orders";

		PreparedStatement pst = con.prepareStatement(sql);
		List<Order> orderlist = new ArrayList<Order>();

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
            int id =rs.getInt("id");
			int user_id = rs.getInt("user_id");
			int book_id = rs.getInt("book_id");
			int quantity =rs.getInt("quantity");
			String status = rs.getString("status");
			Date ordered_date=rs.getDate("order_date");
			
			
			Order b = new Order();
			b.setId(id);
			b.setUser_id(user_id);
			b.setBook_id(book_id);
			b.setQuantity(quantity);
			b.setStatus(status);
			b.setOrder_date(ordered_date.toLocalDate());
			

			orderlist.add(b);

		}

		
	

	
	return orderlist;
	}
	
	
	
	
	public List<Order> listorder() throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select o.id,user_id,book_id,quantity,status,order_date,u.name as username,b.name as bookname from orders o,users u,books b where u.id=o.user_id and b.id=o.book_id";

		PreparedStatement pst = con.prepareStatement(sql);
		List<Order> orderlist = new ArrayList<Order>();

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
            int id =rs.getInt("id");
			int user_id = rs.getInt("user_id");
			int book_id = rs.getInt("book_id");
			int quantity =rs.getInt("quantity");
			String status = rs.getString("status");
			Date ordered_date=rs.getDate("order_date");
			String username=rs.getString("username");
			String bookname=rs.getString("bookname");
			
			Order b = new Order();
			b.setId(id);
			b.setUser_id(user_id);
			b.setBook_id(book_id);
			b.setQuantity(quantity);
			b.setStatus(status);
			b.setOrder_date(ordered_date.toLocalDate());
			b.setUserName(username);
			b.setBookName(bookname);
			orderlist.add(b);

		}

		
	

	
	return orderlist;
	
	
	}

}
