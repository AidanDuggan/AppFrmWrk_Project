package ie.aidan.domain;

public class Question {

	private int question_id;
	private String questiontext;
	private int classroom_id;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private int correctanswer;
	private boolean isselected;
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestiontext() {
		return questiontext;
	}
	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}
	public int getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public int getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(int correctanswer) {
		this.correctanswer = correctanswer;
	}
	public boolean isIsselected() {
		return isselected;
	}
	public void setIsselected(boolean isselected) {
		this.isselected = isselected;
	}
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", questiontext="
				+ questiontext + ", classroom_id=" + classroom_id + ", answer1="
				+ answer1 + ", answer2=" + answer2 + ", answer3=" + answer3
				+ ", answer4=" + answer4 + ", correctanswer=" + correctanswer
				+ "]";
	} 
	
	
}
