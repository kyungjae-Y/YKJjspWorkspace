package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String SQL = "insert into board(no, writer, subject, contents, regDate) values(?,?,?,?,?)";
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

	//	보드 리스트 가져오기
	public ArrayList<Board> boardList() {
		String SQL = "select * from board";
		getConnect();
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String contents = rs.getString("contents");
				String regDate = rs.getString("regDate");
				Board b = new Board(no, writer, regDate, subject, contents);
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