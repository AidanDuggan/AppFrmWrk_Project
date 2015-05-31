package ie.aidan.adf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ie.aidan.dao.QuestionRepository;
import ie.aidan.domain.Question;


@Component
@Transactional
public class ServiceImplementation implements ServiceInterface{

	QuestionRepository questions;
	
	@Autowired
	public ServiceImplementation(QuestionRepository questions) {
		this.questions = questions;
	}
	
	public void insertQuestion(String questiontextin, Integer classroom_id,
			String answer1, String answer2, String answer3, String answer4,
			Integer correctanswer) {
		Question question = new Question();
		question.setQuestiontext(questiontextin);
		question.setClassroom_id(classroom_id);
		question.setAnswer1(answer1);
		question.setAnswer2(answer2);
		question.setAnswer3(answer3);
		question.setAnswer4(answer4);
		question.setCorrectanswer(correctanswer);
		questions.insert(question);
		
	}

	public boolean CheckIfQuestionExists(String question_text) {
		
		return questions.CheckIfQuestionExists(question_text);
	}

}
