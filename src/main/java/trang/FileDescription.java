package trang;

public class FileDescription {
	private String filename;
	private String filedest;
	
	public FileDescription() {
		this("Value.xlsx"," ");
	}
	
	
	public FileDescription(String filename) {
		this(filename, " ");
	}
	
	public FileDescription(String filename, String filedest) {
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
