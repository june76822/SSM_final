package board;

import java.sql.Timestamp;

public class BoardDTO {
	private BoardDAO dao = BoardDAO.getInstance();
	public BoardDTO() {
	}

	private String b_code;
	private String mb_code;
	private String title, contents;
	private int viewCnt;
	private Timestamp createdAt, modifiedAt;


	// boardlist 생성자 => 게시판 맨 처음 화면
	public BoardDTO(String b_code, String mb_code, String title, int viewCnt, Timestamp createdAt,
			Timestamp modifiedAt) {
		this.b_code = b_code;
		this.mb_code = mb_code;
		this.title = title;
		this.viewCnt = viewCnt;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	//board add 생성자
	public BoardDTO(String b_code, String mb_code, String title, String contents) {
		this.b_code = dao.boardCode();
		this.mb_code = mb_code;
		this.title = title;
		this.contents = contents;
	}
	
	// getboard and update 용 생성자 
	public BoardDTO(String b_code,String title, String contents) {
		this.b_code = b_code;
		this.title = title;
		this.contents = contents;
	}



	public String getB_code() {
		return b_code;
	}
	
	public void setB_code(String b_code) {
		this.b_code = b_code;
	}

	public String getMb_code() {
		return mb_code;
	}

	public void setMb_code(String mb_code) {
		this.mb_code = mb_code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
}
	