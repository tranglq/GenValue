package trang.form;

import java.util.ArrayList;
import java.util.List;

public class TypeValuesForm {
	private String typename;
	private List<String> values = new ArrayList<>();
	
	public void setTypeName(String typename) {
		this.typename = typename;
	}
	
	public String getTypeName() {
		return this.typename;
	}
	
	public String getValueList(int index) {
		return this.values.get(index);
	}
	
}
