package dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Order;
import util.ConnectionUtil;


public class OrderDAO {

	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();


	public void addorder(Order user) throws Exception {

		JdbcTemplate con = ConnectionUtil.getJdbcTemplate();
		String sql = "insert into orders(user_id,book_id,quantity,status,order_date) values(?,?,?,?,?)";
		Object[] params = { user.getUser_id(), user.getBook_id(),user.getQuantity(),user.getStatus(), Date.valueOf(user.getOrdered_date()) };
		int rows = jdbctemplate.update(sql, params);

		

		System.out.println("no of rows" + rows);

	}

	public void updatestatus(int orderid,String status) throws Exception{
		String sql ="update orders set status=? where id=?";
				int rows =jdbctemplate.update(sql,status,orderid);
		
		System.out.println("OrderDAO-> updateStatus - no of rows updated" +rows);
	}
	public List<Order> listorder() throws Exception {

		String sql = "select id,user_id,book_id,quantity,status,order_date from orders";

		List<Order> orderlist = jdbctemplate.query(sql, (rs,rowNo)-> {


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
			


			return b;
		});

		 
	

	
	return orderlist;
	}
	
	
	
	
	/*public List<Order> listorder() throws Exception {

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
	
	
	}*/

}
