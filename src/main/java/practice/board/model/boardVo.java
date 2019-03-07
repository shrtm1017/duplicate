package practice.board.model;

public class boardVo {
	String board_no;
	String board_title;
	String board_check;
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_check() {
		return board_check;
	}
	public void setBoard_check(String board_check) {
		this.board_check = board_check;
	}
	@Override
	public String toString() {
		return "boardVo [board_no=" + board_no + ", board_title=" + board_title
				+ ", board_check=" + board_check + "]";
	}

}
