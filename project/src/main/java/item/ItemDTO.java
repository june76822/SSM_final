package item;

import java.sql.Timestamp;

public class ItemDTO {
	private String item_code;
	private String cate_code;
	private String name;
	private int price;
	private String image;
	private String des;
	private Timestamp enroll;

	// 아이템 조회용
	public ItemDTO(String item_code, String cate_code, String name, int price,
			 String image, String des, Timestamp enroll) {
		this.item_code = item_code;
		this.cate_code = cate_code;
		this.name = name;
		this.price = price;
		this.image = image;
		this.des = des;
		this.enroll = enroll;
	}

	public String getItem_code() {
		return item_code;
	}

	public String getCate_code() {
		return cate_code;
	}


	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public String getDes() {
		return des;
	}

	public Timestamp getEnroll() {
		return enroll;
	}
}