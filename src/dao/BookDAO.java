package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import util.ConnectionUtil;

public class BookDAO {

	public void addbook(Book user) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into books(name,price,pub_date,author_id) values( ?,?,?,?)";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, user.getName());
		pst.setFloat(2, user.getPrice());
		pst.setDate(3, Date.valueOf(user.getPub_date()));
		pst.setInt(4, user.getAuthor_id());

		int rows = pst.executeUpdate();
		System.out.println("no of rows" + rows);

	}

	public List<Book> listbook() throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,price,author_id,pub_date from books";

		PreparedStatement pst = con.prepareStatement(sql);
		List<Book> booklist = new ArrayList<Book>();

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("id");
			String name = rs.getString("name");
			float price=rs.getFloat("price");
			int author_id=rs.getInt("author_id");
			Date pub_date=rs.getDate("pub_date");
			
			
			Book b = new Book();
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setAuthor_id(author_id);
			b.setPub_date(pub_date.toLocalDate());
			

			booklist.add(b);

		}

		System.out.println(booklist);

		for (Book b : booklist) {
			System.out.println(b);
		}
		return booklist;

	}
}
