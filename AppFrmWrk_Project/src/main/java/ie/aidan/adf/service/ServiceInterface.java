package ie.aidan.adf.service;

import ie.aidan.domain.Question;

public interface ServiceInterface {

	void insertQuestion(String questiontextin, Integer classroom_id, String answer1, 
			String answer2, String answer3,String answer4, Integer correctanswer);
	boolean CheckIfQuestionExists(String question_text);
}
