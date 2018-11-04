package trang.Objects;

import java.util.ArrayList;
import java.util.List;

public class TypeValues {
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
