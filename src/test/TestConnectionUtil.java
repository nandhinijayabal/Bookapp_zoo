package test;


import java.sql.Connection;

import util.ConnectionUtil;

public class TestConnectionUtil {

		public static void main(String[] args) throws Exception{
			
			Connection con = ConnectionUtil.getConnection();
	         System.out.println("Connection:" +con);

}

}