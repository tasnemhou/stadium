package entity;

import java.io.Serializable;

public class Dictionary implements Serializable {
	
	private static final long serialVersionUID = 3736672340163502884L;
	/** 数值值 */
	private String id;
	/** 数值名称 */
	private String name;
	/** 数据标识 */
	private String flag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
