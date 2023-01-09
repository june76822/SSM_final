package reviewBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import util.Code;
import util.DbManager;

public class ReviewBoardDAO {
	private ReviewBoardDAO() {}

	private static ReviewBoardDAO instance = new ReviewBoardDAO();
	
	public ReviewBoardDAO getInstance() {
		return instance;
	}
	
	private Code co = new Code();
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	public boolean addReviewBaord(ReviewBoardDTO reviewBoardDTO) {
		String sql = "insert into reviewboar valuse(?,?,?,?,?,?,?,?)";
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String reviewcode = reviewCode();
			
			conn = DbManager.getConnection("ssm");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewcode);
			pstmt.setString(2, reviewBoardDTO.getMb_coded());
			pstmt.setString(3, reviewBoardDTO.getItem_code());
			pstmt.setString(4, reviewBoardDTO.getRe_title());
			pstmt.setString(5,reviewBoardDTO.getRe_contents());
			pstmt.setInt(6, reviewBoardDTO.getLikeCnt());
			pstmt.setTimestamp(7, timestamp);
			pstmt.setTimestamp(8, timestamp);
			pstmt.execute();
			System.out.println("review up 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("review up 실패");
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	
	public String reviewCode() {
		conn = DbManager.getConnection("ssm");
		String re_code = null;
		try {
			String sql = "select * from reviewboard where re_code = ?";
			re_code = ""+co.rCode();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				re_code = ""+co.rCode();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, re_code);
				rs = pstmt.executeQuery();
			}
			return re_code;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
