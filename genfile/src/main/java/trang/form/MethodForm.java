package trang.form;

import java.util.ArrayList;
import java.util.List;

public class MethodForm {
	private String methodname;
	private List<TypeValuesForm> typeslist = new ArrayList<>();
	
	public MethodForm(String methodname, List<TypeValuesForm> values) {
		this.methodname = methodname;
		this.typeslist = values;
	}
	
	public void setMethod(String methodname) {
		this.methodname = methodname;
	}
	
	public String getMethod() {
		return this.methodname;
	}
	
	public void setAType(TypeValuesForm typename) {
		this.typeslist.add(typename);
	}
	
	public TypeValuesForm getAtype(int index) {
		return this.typeslist.get(index);
	}
}
