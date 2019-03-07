package practice.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private String file_title;
	private String file_path;
	private Date reg_dt;


	public String getFile_title() {
		return file_title;
	}

	public void setFile_title(String file_title) {
		this.file_title = file_title;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getReg_dt_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "UserVo [mem_id=" + mem_id + ", mem_pass=" + mem_pass
				+ ", mem_name=" + mem_name + ", reg_dt=" + reg_dt + "]";
	}

	
	

}
