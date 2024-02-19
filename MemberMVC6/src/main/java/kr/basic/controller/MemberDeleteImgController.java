package kr.basic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

public class MemberDeleteImgController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		Member vo = MemberDAO.getInstance().memberContent(num);
		Path filePath = Paths.get(saveDirectory, vo.getsFileName());
		try {
			Files.deleteIfExists(filePath);
			System.out.println("파일 삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int cnt = MemberDAO.getInstance().memberUploadPhoto(num, null, null);
		if (cnt > 0) {
			response.getWriter().print("success");
		} else {
			response.getWriter().print("fail");
		}
		return null;
	}
}