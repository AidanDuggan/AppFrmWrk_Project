package ie.aidan.dao;


import ie.aidan.domain.Question;

import java.util.List;

public interface QuestionRepository {

	void insert(Question newquestion);
	List<Question> getAllQuestions();
	void delete(Integer question_id);
	Question findByQuestionId(Integer question_id);
	boolean CheckIfQuestionExists(String question_text);
	void select(Question question);
	void setAllToUnSelected();
	List<Question> getSelectedQuestions();
}
