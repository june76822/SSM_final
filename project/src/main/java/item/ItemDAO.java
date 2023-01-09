package item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import user.UserDTO;
import util.DbManager;

public class ItemDAO {

	private ItemDAO() {
	}

	private static ItemDAO instance = new ItemDAO();

	public static ItemDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	ArrayList<CartDTO> cartList;

	// 카테고리가 입력받은 카테고리 이름으로 시작하는 상품을 ArrayList로 만들어서 반환
	public ArrayList<ItemDTO> getItemList(String cate_name) {

		ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
		ItemDTO item;

		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from items where cate_name like ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate_name + '%');
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String itemCode = rs.getString(1);
				String cateCode = rs.getString(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				String image = rs.getString(5);
				String des = rs.getString(6);
				Timestamp enroll = rs.getTimestamp(7);

				item = new ItemDTO(itemCode, cateCode, name, price, image, des, enroll);

				itemList.add(item);
			}
			return itemList;
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

	public ArrayList<CartDTO> getCartList(UserDTO member) {
		cartList = new ArrayList<>();
		CartDTO cart = null;

		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from ssm.cartItemList where mb_code=? order by enroll desc";
			pstmt = conn.prepareStatement(sql);
//			System.out.println("member.getMb_code() : "+member.getMb_code());
			pstmt.setString(1, member.getMb_code());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String cartItem_Code = rs.getString(1);
				String mb_Code = rs.getString(2);
				String item_Code = rs.getString(3);
				String size = rs.getString(4);
				String quantity = rs.getString(5);
				Timestamp enroll = rs.getTimestamp(6);

				cart = new CartDTO(cartItem_Code, mb_Code, item_Code, size, quantity, enroll);

				cartList.add(cart);
			}
			return cartList;
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

	public ArrayList<WishItemDTO> getWishList(UserDTO member) {
		ArrayList<WishItemDTO> wishList = new ArrayList<>();

		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from wishItemList where mb_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMb_code());
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String wishItem_code = rs.getString(1);
				String mb_code = rs.getString(2);
				String item_code = rs.getString(3);
				String size = rs.getString(4);
				Timestamp enroll = rs.getTimestamp(5);

				WishItemDTO wish = new WishItemDTO(wishItem_code, mb_code, item_code, size, enroll);
				wishList.add(wish);
			}
			return wishList;
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

	public ArrayList<OrderDTO> getOrderList(UserDTO member) {
		ArrayList<OrderDTO> orderList = new ArrayList<OrderDTO>();
		OrderDTO order;

		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from order_List where mb_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMb_code());
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String orderCode = rs.getString(1);
				String mbCode = rs.getString(2);
				Timestamp orderDate = rs.getTimestamp(3);
				String name = rs.getString(4);
				String address = rs.getString(5);
				String contact = rs.getString(6);

				order = new OrderDTO(orderCode, mbCode, orderDate, name, address, contact);

				orderList.add(order);
			}
			return orderList;
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

	public ArrayList<OrderItemDTO> getOrderItemList(String orderCode) {
		ArrayList<OrderItemDTO> orderItemList = new ArrayList<>();
		OrderItemDTO item;

		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from orderItemList where order_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderCode);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String orderItem_Code = rs.getString(1);
				String order_code = rs.getString(2);
				String item_code = rs.getString(3);
				String size = rs.getString(4);
				int count = rs.getInt(5);

				item = new OrderItemDTO(orderItem_Code, orderCode, item_code, size, count);

				orderItemList.add(item);
			}
			return orderItemList;
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

	// 서치용
	public ArrayList<ItemDTO> searchItemList(String keyword) {
		ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
		;
		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from items where ( cate_name like '%" + keyword + "%' OR  item_name like '%"
					+ keyword + "%' OR des like '%" + keyword + "%')";
			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString(1);
				String cateCode = rs.getString(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				String image = rs.getString(5);
				String des = rs.getString(6);
				Timestamp enroll = rs.getTimestamp(7);

				ItemDTO item = new ItemDTO(code, cateCode, name, price, image, des, enroll);
				list.add(item);
			}
			return list;
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

	/// 카테고리
	public ItemDTO getItem(String itemCode) {
		ItemDTO item = null;
		conn = DbManager.getConnection("ssm");

		try {
			String sql = "select * from items where item_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, itemCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String code = rs.getString(1);
				String cateName = rs.getString(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				String image = rs.getString(5);
				String des = rs.getString(6);
				Timestamp enroll = rs.getTimestamp(7);
				item = new ItemDTO(code, cateName, name, price, image, des, enroll);

			}
			return item;
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
