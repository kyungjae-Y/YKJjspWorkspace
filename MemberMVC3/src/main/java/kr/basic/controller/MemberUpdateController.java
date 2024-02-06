package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;
import kr.basic.model.Member;

public class MemberUpdateController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if (req.getParameter("num") == null) {
			return "memberContent";
		}
		int num = Integer.parseInt(req.getParameter("num"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		Member m = new Member();
		m.setNum(num);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().memberUpdate(m);
		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not update");
		}
	}
}