package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {	
	
	public static Connection getConnection(String database) {
		Connection conn = null;
		String url = String.format("jdbc:mysql://ssm-database.cf3iiz1fyl1v.ap-northeast-2.rds.amazonaws.com:3306/%s?serverTimezone=UTC",database);
		String user = "ssm_root";
		String password = "iNX!3h31Jm";

		
		// DBManager.getConnection(); 
				// ㄴ 외부 클래스에서 디비 연동이 필요할때, 언제든 connection을 얻어갈수 있다.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB연동 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연동 실패");
			return null;
		}
	}
}


//package util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DbManager {
//	
//	public static Connection getConnection(String database) {
//		Connection conn = null ;
//		
//		
//		String url = String.format("jdbc:mysql://database-1.ccacf88b9m57.us-west-1.rds.amazonaws.com:3306/%s?serverTimezone=UTC", database); 
//		String user = "admin"; 
//		String password = "gkszxc21%%";
//		//+"?serverTimezone=UTC"
//		// DBManager.getConnection(); 
//		// ㄴ 외부 클래스에서 디비 연동이 필요할때, 언제든 connection을 얻어갈수 있다.
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			conn = DriverManager.getConnection(url+database, user, password);
//			System.out.println("DB 연동 성공");
//			return conn;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.println("DB 연동 실패");
//			return null;
//		}
//		
//	}
//}
