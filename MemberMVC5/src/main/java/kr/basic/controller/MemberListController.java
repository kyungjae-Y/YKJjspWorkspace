package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

public class MemberListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> list = MemberDAO.getInstance().memberList();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		if (session.getAttribute("log") != null) {
			int num = (int) session.getAttribute("log");
			request.setAttribute("num", num);
		} else {
			request.setAttribute("num", null);
		}
		return "memberList";
	}
}