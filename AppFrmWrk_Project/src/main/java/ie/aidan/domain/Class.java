package ie.aidan.domain;

public class Class {
	private int class_id;
	private String class_name;
	private int teacher_id;
	
	public int getclass_id() {
		return class_id;
	}
	public void setclass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getclass_name() {
		return class_name;
	}
	public void setclass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getteacher_id() {
		return teacher_id;
	}
	public void setteacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	@Override
	public String toString() {
		return "class [class_id=" + class_id + ", class_name=" + class_name
				+ ", teacher_id=" + teacher_id + "]";
	}	
}
