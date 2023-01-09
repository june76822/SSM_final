package item;

import java.sql.Timestamp;

public class OrderItemDTO {
	private String orderItem_Code;
	private String order_code;
	private String item_code;
	private String size;
	private int count;

	public OrderItemDTO(String orderItem_Code, String order_code, String item_code, String size, int count) {
		super();
		this.orderItem_Code = orderItem_Code;
		this.order_code = order_code;
		this.item_code = item_code;
		this.size = size;
		this.count = count;
	}

	public String getOrderItem_Code() {
		return orderItem_Code;
	}

	public String getOrder_code() {
		return order_code;
	}

	public String getItem_code() {
		return item_code;
	}

	public String getSize() {
		return size;
	}

	public int getCount() {
		return count;
	}

}
