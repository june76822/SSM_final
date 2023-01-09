package item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DbManager;

public class StockDAO {
	private static StockDAO instance = new StockDAO();
	public static StockDAO getInstance() {
		return instance ; 
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	
	//
		public StockDTO getStock(String itemCode) {
			StockDTO stock = null; 
			conn = DbManager.getConnection("ssm");
			
			try {
				String sql = "select * from itemSizeStock where item_code = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, itemCode);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					int xs = rs.getInt(3);
					int s = rs.getInt(4);
					int m = rs.getInt(5);
					int l = rs.getInt(6);
					int xl = rs.getInt(7);
					int xxl = rs.getInt(8);
					stock = new StockDTO(xs, s, m, l, xl, xxl);
					
				}
				return stock;
			} catch (Exception e) {
				System.out.println("?");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return null;
		}
}



