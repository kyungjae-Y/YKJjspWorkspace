package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

public class MemberContentController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		int num = -1;
		if (request.getParameter("num") == null) {
			return "redirect:" + ctx + "/memberLogin.do";
		} else {
			num = Integer.parseInt(request.getParameter("num"));
		}
		Member vo = MemberDAO.getInstance().memberContent(num);
		request.setAttribute("vo", vo);
		return "memberContent";
	}
}