package item;

import java.sql.Timestamp;

public class CartDTO {
	private String cartItem_Code;
	private String mb_Code;
	private String item_Code;
	private String size;
	private String quantity;
	private Timestamp enroll;
	
	public CartDTO(String cartItem_Code, String mb_Code, String item_Code, String size, String quantity,
			Timestamp enroll) {
		this.cartItem_Code = cartItem_Code;
		this.mb_Code = mb_Code;
		this.item_Code = item_Code;
		this.size = size; 
		this.quantity = quantity;
		this.enroll = enroll;
	}

	public String getCartItem_Code() {
		return cartItem_Code;
	}

	public String getMb_Code() {
		return mb_Code;
	}

	public String getItem_Code() {
		return item_Code;
	}
	
	public String getSize() {
		return size;
	}

	public String getQuantity() {
		return quantity;
	}

	public Timestamp getEnroll() {
		return enroll;
	}

}
