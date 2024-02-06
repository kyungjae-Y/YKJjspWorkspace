package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;
import kr.basic.model.Member;

public class MemberInsertController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if (req.getParameter("id") == null) {
			return "memberInsert";
		}
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		Member m = new Member();
		m.setId(id);
		m.setPass(pass);
		m.setName(name);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().memberInsert(m);
		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not insert");
		}
	}
}