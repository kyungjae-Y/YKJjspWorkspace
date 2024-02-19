package kr.basic.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private MemberDAO() {
	}

	static private MemberDAO instance = new MemberDAO();

	static public MemberDAO getInstance() {
		return instance;
	}

	private static SqlSessionFactory sqlSessionFactory;
	//	맨 처음에 무조건 한번만 실행되는 블럭
	static {
		try {
			String resource = "kr/basic/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Member> memberList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Member> list = session.selectList("memberList");
		session.close();
		return list;
	}

	public int memberInsert(Member vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("memberInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}

	public boolean isValidId(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("isValidId", id);
		session.close();
		return cnt == 0 ? true : false;
	}

	public boolean checkLogin(String id, String pw) {
		return false;
	}

	public int getMemberNo(String id) {
		return 0;
	}

	public int memberDelete(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("memberDelete", id);
		session.commit();
		session.close();
		return cnt;
	}

	public Member memberContent(int num) {
		return null;
	}

	public int memberUpdate(Member vo) {
		return 0;
	}

	public int memberUploadPhoto(int num, String oFileName, String sFileName) {
		return 0;
	}
}