package user;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import util.*;

public class UserDAO {
	private UserDAO() {
	}

	private static UserDAO instance = new UserDAO();
	private static String log;
	public static UserDAO getInstance() {
		return instance;
	}
    // 싱글 톤 
	
	// 맴버 변수 
	private Code co = new Code();	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public String getLog() {
		return log;
	}
	
	//join member
	public boolean joinMember(UserDTO userDto) {
		conn = DbManager.getConnection("ssm");

		try {
			Date date = new Date(userDto.getYear() - 1900, userDto.getMonth() - 1, userDto.getDay());
			Timestamp birth = new Timestamp(date.getTime());
			userDto.setEnroll_date(new Timestamp(System.currentTimeMillis()));
			
			String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,userDto.getMb_code());
			pstmt.setString(2, userDto.getId());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4, userDto.getName());
			pstmt.setString(5, userDto.getContact());
			pstmt.setString(6, userDto.getEmail());
			pstmt.setInt(7, userDto.getGender());
			pstmt.setString(8, userDto.getAddress());
			pstmt.setTimestamp(9, birth);
			pstmt.setTimestamp(10, userDto.getEnroll_date());
			
			pstmt.execute();
			
			System.out.println("joinMember complite");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("joinMember fail");
		} finally {
			try {

				conn.close();
				pstmt.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;

	}
	
	
	
	// member code 
	public String mbCode() {
		conn = DbManager.getConnection("ssm"); // ssm db에 접속
		String code = null;
		try {
			String sql = "select * from members where mb_code = ?";
			code = "mb" + co.rCode(); // code 생성
			pstmt = conn.prepareStatement(sql); //pstmt 에 SQL문장을 저장 
			pstmt.setString(1, code);  // 문장의 ?를 CODE로 세팅 
			rs = pstmt.executeQuery();   // 쿼리를 날리고 그에 대한 답변을 RS에 저장 
			while (rs.next()) { // 만약 select * from members where mb_code = (ex)mb7384 가 존재하면 무한반복";
				code = "mb" + co.rCode(); 
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code); // mb_code에 1000~9999번호 중 하나 추가
				rs = pstmt.executeQuery();
				// db에 있는 mb_code를 가져오기
			}

			return code;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	
	public boolean deleteMember(String id, String password) {


		conn=DbManager.getConnection("ssm");
		
		try {
			String sql="delete from members where id = ? and password = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.execute();
			
		return true;
		}catch (Exception e) {
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
		return false;
	
	}
	
	public boolean CheckId(String id) {
		conn=DbManager.getConnection("ssm");
		try {
			String sql="select * from members where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			return true;
		} catch (Exception e) {
			
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
		
	}
	


	// login member
	public UserDTO getUser(String id, String password) {
		UserDTO user = null;
		conn = DbManager.getConnection("ssm");
		
		try {
			String sql = "select * from members where  id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mb_code = rs.getString(1);
				id = rs.getString(2);
				password = rs.getString(3);
				String name = rs.getString(4);
				String contact = rs.getString(5);
				String email = rs.getString(6);
				int gender = rs.getInt(7);
				String address = rs.getString(8);
				Timestamp birth = rs.getTimestamp(9);
				Timestamp enroll_date = rs.getTimestamp(10);
				

				user = new UserDTO(mb_code, id, password, name, contact, email, gender, address, birth, enroll_date);

				log = mb_code;
				return user;
			}
		} catch (Exception e) {
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
		return user;
	}
	
	
	
	// 내정보 변경후 받을때
	public UserDTO getUser(String mb_code) {
		UserDTO user = null;
		conn = DbManager.getConnection("ssm");
		
		try {
			String sql = "select * from members where  mb_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				
				String id = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String contact = rs.getString(5);
				String email = rs.getString(6);
				int gender = rs.getInt(7);
				String address = rs.getString(8);
				Timestamp birth = rs.getTimestamp(9);
				Timestamp enroll_date = rs.getTimestamp(10);
				
				user = new UserDTO(mb_code, id, password, name, contact, email, gender, address,birth,enroll_date);
				log = mb_code;
				return user;
			}
		} catch (Exception e) {
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
		return user;
	}
	
	
	public boolean modifyProfile(UserDTO userdto) {
	
		
		conn=DbManager.getConnection("ssm");
		try {
			String sql="update members set password=?, name=?, contact=?, email=?, gender=?, address=?, birth=? where mb_code=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,userdto.getPassword());
			pstmt.setString(2, userdto.getName());
			pstmt.setString(3, userdto.getContact());
			pstmt.setString(4, userdto.getEmail());
			pstmt.setInt(5, userdto.getGender());
			pstmt.setString(6, userdto.getAddress());
			pstmt.setTimestamp(7, userdto.getBirth());
			pstmt.setString(8, userdto.getMb_code());
			
			pstmt.executeUpdate(); 
			System.out.println("modifyProfileSuccess");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("modifyProfilefail");
		} finally {
			try {

				conn.close();
				pstmt.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	
}
	

}

