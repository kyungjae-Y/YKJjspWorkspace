package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.MemberDAO;

public class MemberLoginController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (req.getParameter("id") == null) {
			return "memberLogin";
		}
		String pw = req.getParameter("pw");
		String dbPw = MemberDAO.getInstance().checkMemberId(id);
		String ctx = req.getContextPath();
		if (dbPw == null || dbPw.equals(pw) == false) {
			return "redirect:" + ctx + "/memberLogin.do";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("log", MemberDAO.getInstance().getMemberNo(id));
			return "redirect:" + ctx + "/memberList.do";
		}
	}
}