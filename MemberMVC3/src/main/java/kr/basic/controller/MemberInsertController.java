package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		Member member = new Member();
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setAge(age);
		member.setEmail(email);
		member.setPhone(phone);
		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().addOneMember(member);
		if (cnt > 0) {
			res.sendRedirect(ctx + "/memberList.do");
		} else {
			throw new ServletException("not insert");
		}
	}
}