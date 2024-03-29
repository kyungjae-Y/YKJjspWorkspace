package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class BoardDAO {
	private BoardDAO() {
	}

	static private BoardDAO instance = new BoardDAO();

	static public BoardDAO getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 보드 추가
	public int boardAdd(Board b) {
		String SQL = "insert into board(b_no, b_writer, b_subject, b_contents, b_regDate) values(?,?,?,?,?)";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, b.getNo());
			ps.setString(2, b.getWriter());
			ps.setString(3, b.getSubject());
			ps.setString(4, b.getContents());
			ps.setString(5, b.getRegDate());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	//	더미 추가
	public int createDummies(int size) {
		int cnt = 0;
		LocalDate date = LocalDate.now();
		String SQL = "insert into board value(null,?,?,?,?)";
		try {
			getConnect();
			for (int i = 1; i <= size; i++) {
				ps = conn.prepareStatement(SQL);
				ps.setString(1, "작성자" + i);
				ps.setString(2, "제목" + i);
				ps.setString(3, "내용" + i);
				ps.setString(4, date.toString());
				cnt = ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	//	보드 리스트 가져오기
	public ArrayList<Board> boardList() {
		String SQL = "select * from board";
		getConnect();
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("b_no");
				String writer = rs.getString("b_writer");
				String subject = rs.getString("b_subject");
				String contents = rs.getString("b_contents");
				String regDate = rs.getString("b_regDate");
				Board b = new Board(no, writer, subject, contents, regDate);
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 보드 삭제
	public int boardDelete(int no) {
		String SQL = "delete from board where b_no=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, no);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 보드 수정 불러오기
	public Board boardContent(int num) {
		String SQL = "select * from board where b_no=?";
		getConnect();
		Board b = null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("b_no");
				String writer = rs.getString("b_writer");
				String subject = rs.getString("b_subject");
				String contents = rs.getString("b_contents");
				String regDate = rs.getString("b_regDate");
				b = new Board(no, writer, subject, contents, regDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return b;
	}

	// 보드 수정
	public int boardUpdate(int no, String subject, String contents) {
		String SQL = "update board set b_subject=?, b_contents=? where b_no=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, subject);
			ps.setString(2, contents);
			ps.setInt(3, no);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 페이징
	public int boardCnt = 5;
	public int curPageNum = 1;

	// 페이지 시작 번호
	public void setCurPageNum(String start) {
		curPageNum = Integer.parseInt(start);
	}

	public int[] getRowData() {
		ArrayList<Board> list = boardList();
		int startNum = (curPageNum - 1) * boardCnt;
		int endNum = startNum + boardCnt;
		endNum = endNum > list.size() ? list.size() : endNum;
		int[] arr = {
			startNum, endNum
		};
		return arr;
	}

	public int pageNumCnt = 3;
	public int startPageNum = 1;

	public void setStartPageNum(String end) {
		startPageNum = Integer.parseInt(end);
	}

	public int getEndPageNum() {
		int endPageNum = startPageNum + pageNumCnt - 1;
		endPageNum = endPageNum > getTotalPageCnt() ? getTotalPageCnt() : endPageNum;
		return endPageNum;
	}

	public int getTotalPageCnt() {
		ArrayList<Board> list = boardList();
		return list.size() % boardCnt == 0 ? list.size() / boardCnt : list.size() / boardCnt + 1;
	}

	public ArrayList<Board> getPagingBoardList() {
		int[] row = getRowData();
		ArrayList<Board> list = new ArrayList<Board>();
		String SQL = "select * from board orders limit ? offset ?";
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, boardCnt);
			ps.setInt(2, row[0]);
			rs = ps.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("b_no");
				String writer = rs.getString("b_writer");
				String subject = rs.getString("b_subject");
				String contents = rs.getString("b_contents");
				String regDate = rs.getString("b_regDate");
				Board b = new Board(num, writer, subject, contents, regDate);
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}