package board;

public class BoardVO {
	private final int no; // 게시글 번호
	private final String writer; // 작성자
	private final String subject; // 제목
	private final String contents; // 내용
	private final String regDate; // 작성일

	public BoardVO(int no, String writer, String subject, String contents, String regDate) {
		this.no = no;
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContents() {
		return contents;
	}

	public String getRegDate() {
		return regDate;
	}

	@Override
	public String toString() {
		return no + " " + writer + " " + subject + " " + contents + " " + regDate;
	}
}