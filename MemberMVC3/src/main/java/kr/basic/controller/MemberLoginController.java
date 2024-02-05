package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.MemberDAO;

@WebServlet("/memberLogin.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		String dbPw = MemberDAO.getInstance().checkLogin(id, pass);
		res.setContentType("text/html; charset=UTF-8");
		String ctx = req.getContextPath();
		PrintWriter writer = res.getWriter();
		if (dbPw == null || dbPw.equals(pass) == false) {
			writer.println("<script>alert('로그인 실패'); location.href='member/memberLogin.jsp;</script>");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("log", MemberDAO.getInstance().getMemberNo(id));
			writer.println("<script>alert(" + id + "님이 로그인하셨습니다'); location.href=" + ctx + "/memberList.do';</script>");
		}
		writer.close();
	}
}