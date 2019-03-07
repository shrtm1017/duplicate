package practice.bulletin.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bulletinVo {
	private String bulletin_no;
	private String board_no;
	private String mem_id;
	private String bulletin_title;
	private String bulletin_content;
	private Date reg_dt;
	private String bulletin_del_check;
	private String bulletin_no2;
	private String group_no;
	public String getBulletin_no() {
		return bulletin_no;
	}
	public void setBulletin_no(String bulletin_no) {
		this.bulletin_no = bulletin_no;
	}
	public String getBoard_no() {
		return board_no;
	}
	
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBulletin_title() {
		return bulletin_title;
	}
	public void setBulletin_title(String bulletin_title) {
		this.bulletin_title = bulletin_title;
	}
	public String getBulletin_content() {
		return bulletin_content;
	}
	public void setBulletin_content(String bulletin_content) {
		this.bulletin_content = bulletin_content;
	}
//	public String getReg_dt_fmt() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return sdf.format(reg_dt);
//	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getBulletin_del_check() {
		return bulletin_del_check;
	}
	public void setBulletin_del_check(String bulletin_del_check) {
		this.bulletin_del_check = bulletin_del_check;
	}
	public String getBulletin_no2() {
		return bulletin_no2;
	}
	public void setBulletin_no2(String bulletin_no2) {
		this.bulletin_no2 = bulletin_no2;
	}
	public String getGroup_no() {
		return group_no;
	}
	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}
	@Override
	public String toString() {
		return "bulletinVo [bulletin_no=" + bulletin_no + ", board_no="
				+ board_no + ", mem_id=" + mem_id + ", bulletin_title="
				+ bulletin_title + ", bulletin_content=" + bulletin_content
				+ ", reg_dt=" + reg_dt + ", bulletin_del_check="
				+ bulletin_del_check + ", bulletin_no2=" + bulletin_no2
				+ ", group_no=" + group_no + "]";
	}
	

}
