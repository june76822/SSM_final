package reviewBoard;

import java.sql.Timestamp;

public class ReviewBoardDTO {
	
	private String re_code, mb_coded, item_code;
	private String re_title, re_contents;
	private int likeCnt;
	private Timestamp re_createdAt, re_modifiedAt;
	
	// 생성자 
	
	
	
	public String getRe_code() {
		return re_code;
	}
	public void setRe_code(String re_code) {
		this.re_code = re_code;
	}
	public String getMb_coded() {
		return mb_coded;
	}
	public void setMb_coded(String mb_coded) {
		this.mb_coded = mb_coded;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getRe_title() {
		return re_title;
	}
	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}
	public String getRe_contents() {
		return re_contents;
	}
	public void setRe_contents(String re_contents) {
		this.re_contents = re_contents;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public Timestamp getRe_createdAt() {
		return re_createdAt;
	}
	public void setRe_createdAt(Timestamp re_createdAt) {
		this.re_createdAt = re_createdAt;
	}
	public Timestamp getRe_modifiedAt() {
		return re_modifiedAt;
	}
	public void setRe_modifiedAt(Timestamp re_modifiedAt) {
		this.re_modifiedAt = re_modifiedAt;
	} 
	
	
	
	
	
}
