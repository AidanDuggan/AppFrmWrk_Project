package ie.aidan.web;

import ie.aidan.domain.Question;
import ie.aidan.dao.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository repo;

	@RequestMapping("allQuestions")
	public String getAllquestionItems(Model model) {
		model.addAttribute("allQuestions", repo.getAllQuestions());
		return "question";
	}
	
	@RequestMapping("selectedQuestions")
	public String getSelectedQuestions(Model model) {
		model.addAttribute("selectedQuestions", repo.getSelectedQuestions());
		return "question";
	}
	
	@RequestMapping(value = "InsertQuestion", method = RequestMethod.POST)
	public String create(@RequestParam String questiontextin,@RequestParam Integer classroom_id,
			@RequestParam String answer1,@RequestParam String answer2,@RequestParam String answer3,
			@RequestParam String answer4, @RequestParam Integer correctanswer) {
		Question question = new Question();
		question.setQuestiontext(questiontextin);
		question.setClassroom_id(classroom_id);
		question.setAnswer1(answer1);
		question.setAnswer2(answer2);
		question.setAnswer3(answer3);
		question.setAnswer4(answer4);
		question.setCorrectanswer(correctanswer);
		repo.insert(question);
		return "redirect:allQuestions";
	}
	
	@RequestMapping(value = "{question_id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer question_id) {
		repo.delete(question_id);
		return "redirect:allQuestions";
	}
	
	@RequestMapping(value = "SelectQuestion{question_id}", method = RequestMethod.POST)
	public String selectQuestion(@PathVariable Integer question_id) {
		repo.setAllToUnSelected();
		Question Question = repo.findByQuestionId(question_id);
		Question.setIsselected(true);
		repo.select(Question);
		//repo.delete(question_id);
		return "redirect:selectedQuestions";
	}
	
}
