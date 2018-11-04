package trang.Objects;

public class KeyWordInValue {
	private String start;
	private String endd;
	private String classkey;
	private String lit;
	
	public KeyWordInValue() {
		this.start = "START CLASSLITERALS";
		this.endd = "END CLASSLITERALS";
		this.classkey = "CLASSNAME";
		this.lit = "LITERALS";
	}
	
	public String getStart() {
		return this.start;
	}
	
	public String getEnd() {
		return this.endd;
	}
	
	public String getClassKey() {
		return this.classkey;
	}
	
	public String getLit() {
		return this.lit;
	}
}
