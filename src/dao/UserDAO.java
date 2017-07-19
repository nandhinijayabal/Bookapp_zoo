package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.user;
import util.ConnectionUtil;

public class UserDAO {

	public void register(user user) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into users(name,email_id,password) values( ?,?,?)";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, user.getName());
		pst.setString(2, user.getEmail_id());
		pst.setString(3, user.getPassword());

		int rows = pst.executeUpdate();
		System.out.println("no of rows" + rows);
	}

	public user login(String email_id, String password) throws Exception {
		String sql = "select id,name,email_id,password from users where email_id = ? and password = ? ";
		user user = null;

		Connection con = ConnectionUtil.getConnection();

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, email_id);
		pst.setString(2, password);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {

			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email_id");
			String password1 = rs.getString("password");

			user = new user();
			user.setId(id);
			user.setName(name);
			user.setEmail_id(email_id);
			user.setPassword(password);

			System.out.println(user);

		}
		return user;

	}



}