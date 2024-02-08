package kr.basic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

public class MemberAddController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getServletContext().getRealPath("Uploads");
		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println("saveDirectory = " + saveDirectory);
		MultipartRequest multi = new MultipartRequest(request, saveDirectory.toString(), 5 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		String sFileName = null;
		String oFileName = null;
		if (multi.getFilesystemName("uploadFile") != null) {
			sFileName = multi.getFilesystemName("uploadFile");
			oFileName = multi.getOriginalFileName("uploadFile");
			String fileType = multi.getContentType("uploadFile");
			System.out.println("fileType = " + fileType);
		}
		String id = multi.getParameter("id");
		String pass = multi.getParameter("pass");
		String name = multi.getParameter("name");
		int age = Integer.parseInt(multi.getParameter("age"));
		String email = multi.getParameter("email");
		String phone = multi.getParameter("phone");
		Member vo = null;
		System.out.println("saveFileName = " + sFileName);
		System.out.println("orginFileName = " + oFileName);
		vo = new Member(id, pass, name, age, email, phone, oFileName, sFileName);
		String ctx = request.getContextPath();
		int cnt = MemberDAO.getInstance().memberInsert(vo);
		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not insert");
		}
	}
}