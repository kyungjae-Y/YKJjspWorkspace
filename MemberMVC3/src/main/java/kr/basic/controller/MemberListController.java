package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;
import kr.basic.model.Member;

public class MemberListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Member> list = MemberDAO.getInstance().memberList();
		req.setAttribute("list", list);
		return "memberList";
	}
}