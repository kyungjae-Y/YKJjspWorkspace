package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

public class MemberContentController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		int num = -1;
		if (req.getParameter("num") == null) {
			return "redirect:" + ctx + "/memberLogin.do";
		} else {
			num = Integer.parseInt(req.getParameter("num"));
		}
		Member m = MemberDAO.getInstance().memberContent(num);
		req.setAttribute("m", m);
		return "memberContent";
	}
}