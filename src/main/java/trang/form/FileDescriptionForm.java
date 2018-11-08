package trang.form;

public class FileDescriptionForm {
	private String filename;
	private String filedest;
	
	public FileDescriptionForm() {
		this("Value.xlsx"," ");
	}
	
	
	public FileDescriptionForm(String filename) {
		this(filename, " ");
	}
	
	public FileDescriptionForm(String filename, String filedest) {
		this.filename = filename;
		this.filedest = filedest;
	}
	
	
	public void setFileDest(String filedest) {
		this.filedest= filedest;
	}
	
	public void setFileName(String filename) {
		this.filename = filename;
	}
	
	public String getFileDest() {
		return this.filedest;
	}
	
	public String getFileName() {
		return this.filename;
	}
}
