package item;

import java.sql.Timestamp;

public class WishItemDTO {

	private String wishItem_code, mb_code, item_code, size;
	private Timestamp enroll;

	public WishItemDTO(String wishItem_code, String mb_code, String item_code, String size, Timestamp enroll) {
		this.wishItem_code = wishItem_code;
		this.mb_code = mb_code;
		this.item_code = item_code;
		this.size = size;
		this.enroll = enroll;
	}

	public String getWishItem_code() {
		return wishItem_code;
	}

	public String getMb_code() {
		return mb_code;
	}

	public String getItem_code() {
		return item_code;
	}

	public String getSize() {
		return size;
	}

	public Timestamp getEnroll() {
		return enroll;
	}

}
