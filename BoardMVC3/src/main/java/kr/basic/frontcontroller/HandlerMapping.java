package kr.basic.frontcontroller;

import java.util.HashMap;

import kr.basic.controller.BoardAddController;
import kr.basic.controller.BoardAddDummyController;
import kr.basic.controller.BoardContentController;
import kr.basic.controller.BoardDeleteController;
import kr.basic.controller.BoardListController;
import kr.basic.controller.BoardListPagingController;
import kr.basic.controller.BoardUpdateController;
import kr.basic.controller.Controller;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/boardAddDummy.do", new BoardAddDummyController());
		mappings.put("/boardContent.do", new BoardContentController());
		mappings.put("/boardDelete.do", new BoardDeleteController());
		mappings.put("/boardList.do", new BoardListController());
		mappings.put("/boardListPaging.do", new BoardListPagingController());
		mappings.put("boardUpdate.do", new BoardUpdateController());
		mappings.put("boardAdd.do", new BoardAddController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}