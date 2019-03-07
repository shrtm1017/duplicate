package practice.comment.model;

public class commentVo {
	private String cmt_no;
	private String board_no;
	private String reg_dt;
	private String cmt_del_check;
	private String cmt_content;
	private String mem_id;
	public String getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(String cmt_no) {
		this.cmt_no = cmt_no;
	}
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getCmt_del_check() {
		return cmt_del_check;
	}
	public void setCmt_del_check(String cmt_del_check) {
		this.cmt_del_check = cmt_del_check;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "commentVo [cmt_no=" + cmt_no + ", board_no=" + board_no
				+ ", reg_dt=" + reg_dt + ", cmt_del_check=" + cmt_del_check
				+ ", cmt_content=" + cmt_content + ", mem_id=" + mem_id + "]";
	}
	

}
