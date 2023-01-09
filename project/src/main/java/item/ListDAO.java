package item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import user.UserDTO;
import util.Code;
import util.DbManager;

public class ListDAO {
	private ListDAO() {
	}

	private static ListDAO instance = new ListDAO();

	public static ListDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public boolean addCart(UserDTO loginUser, ItemDTO item, String quantity, String size) {
		conn = DbManager.getConnection("ssm");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String cartItemCode = cartItemCode();

		try {
			conn = DbManager.getConnection("ssm");

			String sql = "insert into cartItemList values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cartItemCode);
			pstmt.setString(2, loginUser.getMb_code());
			pstmt.setString(3, item.getItem_code());
			pstmt.setString(4, size);
			pstmt.setString(5, quantity);
			pstmt.setTimestamp(6, time);

			pstmt.execute();

			System.out.println("addCart done");
			return true;
		} catch (Exception e) {
			System.out.println("addCart fail");
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

	public boolean addWishList(UserDTO loginUser, ItemDTO item, String size) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String wishItemCode = wishItemCode();

		try {
			conn = DbManager.getConnection("ssm");
			String sql = "insert into wishItemList values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wishItemCode);
			pstmt.setString(2, loginUser.getMb_code());
			pstmt.setString(3, item.getItem_code());
			pstmt.setString(4, size);
			pstmt.setTimestamp(5, time);
			pstmt.execute();

			System.out.println("addWish done");
			return true;
		} catch (Exception e) {
			System.out.println("addWish fail");
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

	public String addOrder(UserDTO loginUser, String[] cartItemCodeList) {
		conn = DbManager.getConnection("ssm");

		String code = orderCode();
		System.out.println("orderCode : " + code);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String loginUserCode = loginUser.getMb_code();
		String name = loginUser.getName();
		String address = loginUser.getAddress();
		String contact = loginUser.getContact();

//-insert into order_List---------------------------------------------------------------------------------------------------
		try {
			conn = DbManager.getConnection("ssm");
			String sql = "insert into order_List values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, loginUserCode);
			pstmt.setTimestamp(3, time);
			pstmt.setString(4, name);
			pstmt.setString(5, address);
			pstmt.setString(6, contact);
			pstmt.execute();
			System.out.println(sql);
//-select item_code, size,quantity from cartItemList---------------------------------------------------------
			for (String cartCode : cartItemCodeList) {

				String orderItemCode = orderItemCode();

				conn = DbManager.getConnection("ssm");
				sql = "select item_code, size,quantity from cartItemList where cartItem_code=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cartCode);
				rs = pstmt.executeQuery();

				System.out.println(sql);

				String curItemCode = "";
				String size = "";
				int quantity = 0;
//-insert into orderItemList---------------------------------------------------------------

				while (rs.next()) {
					curItemCode = rs.getString(1);
					size = rs.getString(2);
					quantity = Integer.parseInt(rs.getString(3));
					conn = DbManager.getConnection("ssm");
					sql = "insert into orderItemList values(?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, orderItemCode);
					pstmt.setString(2, code);
					pstmt.setString(3, curItemCode);
					pstmt.setString(4, size);
					pstmt.setInt(5, quantity);
					pstmt.execute();

					System.out.println(sql);
				}
				conn.close();
				pstmt.close();
				rs.close();
//--select size from itemSizeStock--------------------------------------------------------------

				int curStock = 0;

				conn = DbManager.getConnection("ssm");
				sql = "select " + size + " from itemSizeStock where item_code = " + curItemCode;
				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("curStock : " + rs.getString(1));
					curStock = rs.getInt(1);
				}
				int fianlStock = curStock - quantity;
				System.out.println("fianlStock : " + fianlStock);

				System.out.println(sql);
				conn.close();
				pstmt.close();
				rs.close();

//--update itemSizeStock-----------------------------------------------------------------------

				conn = DbManager.getConnection("ssm");
				sql = "update itemSizeStock set " + size + " = " + fianlStock + " where item_code=" + curItemCode;
				pstmt = conn.prepareStatement(sql);
				pstmt.execute();

				System.out.println(sql);
//--delete from cartItemList--------------------------------------------------------------------------------------------------
				conn = DbManager.getConnection("ssm");
				sql = "delete from cartItemList where cartItem_code = " + cartCode;
				pstmt = conn.prepareStatement(sql);
				pstmt.execute();
				System.out.println(sql);

			}
			System.out.println("addOrder done");
			return code;
		} catch (Exception e) {
			System.out.println("addOrder fail");
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
//----------------------------------------------------------------------------------------------------

	public boolean removeCartItem(String[] removeItemCode) {
		try {
			for (String code : removeItemCode) {
				conn = DbManager.getConnection("ssm");
				String sql = "delete from cartItemList where cartItem_code = " + code;
				pstmt = conn.prepareStatement(sql);
				pstmt.execute();
			}
			System.out.println("removeCart done");
			return true;
		} catch (Exception e) {
			System.out.println("removeCart fail");
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

	public boolean removeWishItem(String[] removeItemCode) {
		try {
			for (String code : removeItemCode) {
				conn = DbManager.getConnection("ssm");
				String sql = "delete from wishItemList where wishItem_code = " + code;
				pstmt = conn.prepareStatement(sql);
				pstmt.execute();
			}
			System.out.println("removeWish done");
			return true;
		} catch (Exception e) {
			System.out.println("removeWish fail");
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

//	public boolean wishToCart(String[] wishItemCode, UserDTO user) {
//		ItemDAO iDao = ItemDAO.getInstance();
//
//		Timestamp time = new Timestamp(System.currentTimeMillis());
//		String cartItemCode = cartItemCode();
//
//		try {
//			conn = DbManager.getConnection("ssm");
//
//			for (String code : wishItemCode) {
//				String sql = "select item_code from wishItemList where wishItem_code = " + code;
//				pstmt = conn.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//
//				String itemCode;
//				
//				while (rs.next()) {
//					itemCode = rs.getString(1);
//				}
//				
//				ItemDTO item = iDao.getItem(itemCode);
//
//				sql = "insert into cartItemList values(?,?,?,?,?,?)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, cartItemCode);
//				pstmt.setString(2, user.getMb_code());
//				pstmt.setString(3, item.getItem_code());
//				pstmt.setString(4, size);
//				pstmt.setString(5, quantity);
//				pstmt.setTimestamp(6, time);
//
//				pstmt.execute();
//			}
//			System.out.println("removeWish done");
//			return true;
//		} catch (Exception e) {
//			System.out.println("removeWish fail");
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//				pstmt.close();
//				rs.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return false;
//	}

	//
	// 코드 생성용
	//

	public String cartItemCode() {
		Code co = new Code();
		conn = DbManager.getConnection("ssm"); // ssm db에 접속
		String code = null;
		try {
			String sql = "select * from cartItemList where cartItem_code = ?";
			code = "" + co.rCode(); // code 생성
			pstmt = conn.prepareStatement(sql); // pstmt 에 SQL문장을 저장
			pstmt.setString(1, code); // 문장의 ?를 CODE로 세팅
			rs = pstmt.executeQuery(); // 쿼리를 날리고 그에 대한 답변을 RS에 저장
			while (rs.next()) { // 만약 select * from members where mb_code = (ex)mb7384 가 존재하면 무한반복";
				code = "" + co.rCode();
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

	// 삭제하기

	public String wishItemCode() {
		Code co = new Code();
		conn = DbManager.getConnection("ssm"); // ssm db에 접속
		String code = null;
		try {
			String sql = "select * from wishItemList where wishItem_code = ?";
			code = "" + co.rCode(); // code 생성
			pstmt = conn.prepareStatement(sql); // pstmt 에 SQL문장을 저장
			pstmt.setString(1, code); // 문장의 ?를 CODE로 세팅
			rs = pstmt.executeQuery(); // 쿼리를 날리고 그에 대한 답변을 RS에 저장
			while (rs.next()) { // 만약 select * from members where mb_code = (ex)mb7384 가 존재하면 무한반복";
				code = "" + co.rCode();
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

	public String orderCode() {
		Code co = new Code();
		conn = DbManager.getConnection("ssm"); // ssm db에 접속
		String code = "" + co.rCode(); // code 생성

		try {
			String sql = "select * from order_List where order_code = ?";
			pstmt = conn.prepareStatement(sql); // pstmt 에 SQL문장을 저장
			pstmt.setString(1, code); // 문장의 ?를 CODE로 세팅
			rs = pstmt.executeQuery(); // 쿼리를 날리고 그에 대한 답변을 RS에 저장
			while (rs.next()) { // 만약 select * from members where mb_code = (ex)mb7384 가 존재하면 무한반복";
				code = "" + co.rCode();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code); // mb_code에 1000~9999번호 중 하나 추가
				rs = pstmt.executeQuery();
				// db에 있는 mb_code를 가져오기
			}

			return code;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("??????????????????????????????????");
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

	public String orderItemCode() {
		Code co = new Code();
		conn = DbManager.getConnection("ssm"); // ssm db에 접속
		String code = "" + co.rCode();
		try {
			String sql = "select * from orderItemList where orderItem_code = ?";
			pstmt = conn.prepareStatement(sql); // pstmt 에 SQL문장을 저장
			pstmt.setString(1, code); // 문장의 ?를 CODE로 세팅
			rs = pstmt.executeQuery(); // 쿼리를 날리고 그에 대한 답변을 RS에 저장
			while (rs.next()) { // 만약 select * from members where mb_code = (ex)mb7384 가 존재하면 무한반복";
				code = "" + co.rCode();
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

}