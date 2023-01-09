
package user;

import java.sql.Timestamp;

public class UserDTO {
	private UserDAO dao = UserDAO.getInstance();
	private String mb_code, id, password, name;
	private String contact;
	private String email;
	private int gender;
	private int year, month, day;
	private String address;
	private Timestamp enroll_date;
	private Timestamp birth;

	// 유저 회원 가입

	public UserDTO(String id, String password, String name, String contact, String email, int gender, String address,int year, int month, int day) {
		this.mb_code = dao.mbCode();
		this.id = id;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// login
	public UserDTO(String mb_code, String id, String password, String name, String contact, String email, int gender, String address,Timestamp birth,Timestamp enroll_date) {

		this.mb_code = mb_code;
		this.id = id;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.birth = birth;
		this.enroll_date = enroll_date;

	}
	
	// 내 정보 수정 입니다
	
	public UserDTO(String mb_code, String password, String name, String contact, String email, int gender, String address,Timestamp birth) {
		this.mb_code = mb_code;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.birth=birth;
		
	}
	



	public UserDTO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public UserDTO(String name) {
		this.name=name;
	}

	// getter & setter

	public String getMb_code() {
		return mb_code;
	}

	public void setMb_code(String mb_code) {
		this.mb_code = mb_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getBirth() {
		return birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	public Timestamp getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Timestamp enroll_date) {
		this.enroll_date = enroll_date;
	}

}

