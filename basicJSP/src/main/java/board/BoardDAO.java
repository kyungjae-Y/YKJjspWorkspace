package board;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private List<BoardVO> boardList;

	public BoardDAO() {
		// Initialize the boardList, either in the constructor or through a database connection
		this.boardList = new ArrayList<>();
	}

	// Add a new board to the list
	public void addBoard(BoardVO board) {
		boardList.add(board);
	}

	// Get all boards from the list
	public List<BoardVO> getAllBoards() {
		return new ArrayList<>(boardList);
	}

	// Get a specific board by its number
	public BoardVO getBoardByNo(int boardNo) {
		for (BoardVO board : boardList) {
			if (board.getNo() == boardNo) {
				return board;
			}
		}
		return null; // Return null if board is not found
	}

	// Update a board in the list
	public void updateBoard(BoardVO updatedBoard) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getNo() == updatedBoard.getNo()) {
				boardList.set(i, updatedBoard);
				break;
			}
		}
	}

	// Delete a board from the list
	public void deleteBoard(int boardNo) {
		boardList.removeIf(board -> board.getNo() == boardNo);
	}
}