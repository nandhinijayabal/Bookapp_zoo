package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		 
        Connection con = null;
 
        try {
             
        	 Class.forName("com.mysql.jdbc.Driver");
 	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
             
        } catch (Exception e) {
            throw new Exception(e);
        }
         
        return con;
 
    }
	 
	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
	        System.out.println(conn);

}
}