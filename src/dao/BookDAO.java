package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Book;
import util.ConnectionUtil;

public class BookDAO {
	
	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();

	public void addbook(Book user) throws Exception {

		String sql = "insert into books(name,price,pub_date,author_id) values( ?,?,?,?)";
		Object[] params = { user.getName(), user.getPrice(), Date.valueOf(user.getPub_date()), user.getAuthor_id() };
		int rows = jdbctemplate.update(sql, params);
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
			float price = rs.getFloat("price");
			int author_id = rs.getInt("author_id");
			Date pub_date = rs.getDate("pub_date");

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
