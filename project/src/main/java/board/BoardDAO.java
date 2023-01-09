package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.Code;
import util.DbManager;

public class BoardDAO {
	ArrayList<BoardDTO> boardList;

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	private Code co = new Code();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// add
	public boolean addBoard(BoardDTO boardDto) {
		String sql = "insert into board(b_code,mb_code,title,contents,createdAt) values(?,?,?,?,?)";
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String boardCode = boardCode();

			conn = DbManager.getConnection("ssm");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardCode);
			pstmt.setString(2, boardDto.getMb_code());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setTimestamp(5, timestamp);
			pstmt.execute();

			System.out.println("board up 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("board up실패");
			return false;
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public String boardCode() {
		conn = DbManager.getConnection("ssm");
		String b_code = null;
		try {
			String sql = "select * from board where b_code = ?";
			b_code = "" + co.rCode();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				b_code = "" + co.rCode();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b_code);
				rs = pstmt.executeQuery();
			}
			return b_code;
		} catch (Exception e) {
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

	// 게시판 모든 글 가져오기
	public ArrayList<BoardDTO> getboardList() {
		boardList = new ArrayList<>();
		conn = DbManager.getConnection("ssm");
		try {
			String sql = "select * from board ORDER BY createdAt DESC"; // 순서대로 정렬
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String b_code = rs.getString(1);
				String mb_code = rs.getString(2);
				String title = rs.getString(3);
				int viewCnt = rs.getInt(5);
				Timestamp createdAt = rs.getTimestamp(6);
				Timestamp modifiedAt = rs.getTimestamp(7);

				BoardDTO dto = new BoardDTO(b_code, mb_code, title, viewCnt, createdAt, modifiedAt);
				boardList.add(dto);
			}
			return boardList;
		} catch (Exception e) {
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

	public BoardDTO getBoard(String b_code) {
		conn = DbManager.getConnection("ssm");
		BoardDTO dto = null;
		try {
			String sql = "select * from board where b_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO(b_code, rs.getString(3), rs.getString(4));
				dto.setB_code(b_code);
				dto.setMb_code(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContents(rs.getString(4));
				dto.setViewCnt(rs.getInt(5));
				dto.setCreatedAt(rs.getTimestamp(6));
				dto.setModifiedAt(rs.getTimestamp(7));

				countUpdate(b_code);

			}
			return dto;
		} catch (Exception e) {
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

	// board 업데이트
	public boolean upDateBoard(BoardDTO boardDto) {
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String sql = "update board set title = ?, contents= ?, modifiedAt = ? where b_code= ?";
//			String sql = String.format(
//					"update board set title = '%s', contents= '%s', modifiedAt = '%s' where b_code= '%s'",
//					boardDto.getTitle(), boardDto.getContents(), timestamp, boardDto.getB_code());

			conn = DbManager.getConnection("ssm");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContents());
			pstmt.setTimestamp(3, timestamp);
			pstmt.setString(4, boardDto.getB_code());

			pstmt.execute();
			System.out.println("board update 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("board update실패");
			return false;
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	// board b_code로 삭제
	public boolean delete(String b_code) {
		conn = DbManager.getConnection("ssm");
		try {
			String sql = "delete from board where b_code= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_code);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	private void countUpdate(String b_code) {
		conn = DbManager.getConnection("ssm");
		int viewCnt = 0;
		try {
			String getReadCountSql = "select viewCnt from board where b_code = ?";
			pstmt = conn.prepareStatement(getReadCountSql);
			pstmt.setString(1, b_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				viewCnt = rs.getInt(1);
				viewCnt++;
			}

			String sql = "update board set viewCnt = ? where b_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viewCnt);
			pstmt.setString(2, b_code);
			pstmt.executeUpdate();// insert,delete,update
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public int like(String b_code) {
//		conn = DbManager.getConnection("ssm");
//		try {
//			String SQL = "update board set likeCnt = likeCnt + 1 WHERE b_code = ?";
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, b_code);
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//				pstmt.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return -1;
//	}
}
