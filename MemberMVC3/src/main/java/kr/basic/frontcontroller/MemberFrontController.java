package kr.basic.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.controller.Controller;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		String ctx = req.getContextPath();
		String command = url.substring(ctx.length());
		Controller controller = null;
		String nextPage = null;
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(req, res);
		if (nextPage != null) {
			if (nextPage.indexOf("redirect:") != -1) {
				res.sendRedirect(nextPage.split(":")[1]);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(req, res);
			}
		}
	}
}
