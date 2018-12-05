package trang.form;

import java.util.ArrayList;
import java.util.List;

public class ClassForm {
	private String classname;
	private List<MethodForm> methodlist = new ArrayList<>();
	
	public void setClass(String classname) {
		this.classname = classname;
	}
	
	public String getClassname() {
		return this.classname;
	}
	
	public void setAMethod(MethodForm methodname) {
		this.methodlist.add(methodname);
	}
	
	public MethodForm getAMethod(int index) {
		return this.methodlist.get(index);
	}
	
	public List<MethodForm> getMethodList(){
		return this.methodlist;
	}
	
	public boolean methodlistIsNull() {
		if(methodlist.get(0) == null) return true;
		else return false;
	}
}
