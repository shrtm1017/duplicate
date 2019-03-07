package practice.file.model;

public class fileVo {

	private String file_no;
	private String bulletin_no;
	private String file_title;
	private String file_path;
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getBulletin_no() {
		return bulletin_no;
	}
	public void setBulletin_no(String bulletin_no) {
		this.bulletin_no = bulletin_no;
	}
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
	@Override
	public String toString() {
		return "fileVo [file_no=" + file_no + ", bulletin_no=" + bulletin_no
				+ ", file_title=" + file_title + ", file_path=" + file_path
				+ "]";
	}
	
	
}
