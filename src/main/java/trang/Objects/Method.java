package trang.Objects;

import trang.Objects.TypeValues;
import java.util.ArrayList;
import java.util.List;

public class Method {
	private String methodname;
	private List<TypeValues> typeslist = new ArrayList<>();
	
	public Method(String methodname, List<TypeValues> values) {
		this.methodname = methodname;
		this.typeslist = values;
	}
	
	public void setMethod(String methodname) {
		this.methodname = methodname;
	}
	
	public String getMethod() {
		return this.methodname;
	}
	
	public void setAType(TypeValues typename) {
		this.typeslist.add(typename);
	}
	
	public TypeValues getAtype(int index) {
		return this.typeslist.get(index);
	}
}
