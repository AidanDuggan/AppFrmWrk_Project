package ie.aidan.domain;
// This class is store information about a particular class in the school (eg 1st class)
public class ClassRoom {
	private int classroom_id;
	private String classroom_name;
	private int teacher_id;
	private boolean isselected;
	
	
	public int getclassroom_id() {
		return classroom_id;
	}
	public void setclassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	public String getclass_name() {
		return classroom_name;
	}
	public void setclass_name(String class_name) {
		this.classroom_name = class_name;
	}
	public int getteacher_id() {
		return teacher_id;
	}
	public void setteacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public boolean isIsselected() {
		return isselected;
	}
	public void setIsselected(boolean isselected) {
		this.isselected = isselected;
	}
	
	@Override
	public String toString() {
		return "ClassRoom [classroom_id=" + classroom_id + ", class_name=" + classroom_name
				+ ", teacher_id=" + teacher_id + ", isselected=" + isselected
				+ "]";
	}	
}
