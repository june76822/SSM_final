package item;

import java.sql.Timestamp;

public class OrderDTO {

	private String orderCode;
	private String mbCode;
	private Timestamp orderDate;
	private String name;
	private String address;
	private String contact;

	public OrderDTO(String orderCode, String mbCode, Timestamp orderDate, String name, String address, String contact) {
		this.orderCode = orderCode;
		this.mbCode = mbCode;
		this.orderDate = orderDate;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public String getMbCode() {
		return mbCode;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}
}
