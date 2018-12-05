package trang.form;

import java.util.ArrayList;
import java.util.List;

public class PackageForm<typename> {
	private String packagename;
	private String classname;
	private String methodname;
	private String typename;
	private List<String> values = new ArrayList<>();
	
	public PackageForm() {

	}
	
	public PackageForm(String packagename, String classname, String methodname, String typename, List<String> values) {
		this.packagename = packagename;
		this.classname = classname;
		this.methodname = methodname;
		this.typename = typename;
		this.values = values;
	}
	
	
	public void setPackage(String packagename) {
		this.packagename = packagename;
	}
	
	public String getPackage() {
		return this.packagename;
	}
	
	public void setClass(String classname) {
		this.classname = classname;
	}
	
	public String getClassname() {
		return this.classname;
	}
	
	public void setMethod(String methodname) {
		this.methodname = methodname;
	}
	
	public String getMethod() {
		return this.methodname;
	}
	
	public void setTypeName(String typename) {
		this.typename = typename;
	}
	
	public String getTypeName() {
		return this.typename;
	}
	
	public String getValueList(int index) {
		return this.values.get(index);
	}
	
	public void setValue(String value) {
		this.values.add(value);
	}
	
	public List<String> getValues(){
		return this.values;
	}

	public String writeMethod(){
		return this.getPackage() + "." + this.getClassname() + "." + this.getMethod();
	}

	public String writeClass(){
		return this.getPackage()+"."+this.getClassname();
	}
}
