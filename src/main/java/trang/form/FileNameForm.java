package trang.form;

public class FileNameForm {
	private String filename;
	private String filedest;
	
	public FileNameForm() {
		this("Value.xlsx"," ");
	}
	
	
	public FileNameForm(String filename) {
		this(filename, " ");
	}
	
	public FileNameForm(String filename, String filedest) {
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

	public String get(){
		return this.filedest + this.filename;
	}
}
