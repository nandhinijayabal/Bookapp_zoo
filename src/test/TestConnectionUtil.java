package test;


import java.sql.Connection;

import org.springframework.jdbc.core.JdbcTemplate;

import util.ConnectionUtil;

public class TestConnectionUtil {

		public static void main(String[] args) throws Exception{
			
			Connection con = ConnectionUtil.getConnection();
	         System.out.println("Connection:" +con);


        JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
        System.out.println(jdbcTemplate);
		}		
}