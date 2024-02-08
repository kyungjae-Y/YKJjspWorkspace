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

import kr.basic.model.MemberDAO;

public class MemberUploadImgController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
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
		int num = Integer.parseInt(multi.getParameter("num"));
		int cnt = MemberDAO.getInstance().memberUploadPhoto(num, oFileName, sFileName);
		if (cnt > 0) {
			response.getWriter().print(sFileName);
		} else {
			response.getWriter().print("fail");
		}
		return null;
	}
}