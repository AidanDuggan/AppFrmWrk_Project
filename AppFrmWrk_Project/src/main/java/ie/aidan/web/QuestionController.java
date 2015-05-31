package ie.aidan.web;

import java.util.List;

import ie.aidan.domain.Question;
import ie.aidan.dao.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class QuestionController {

	
	private QuestionRepository repo;
	
	@Autowired   // added constructor to inject repository
	public QuestionController(QuestionRepository repo2) {
		repo = repo2;
	}

	@RequestMapping("allQuestions")
	public String getAllQuestions(Model model) {
		model.addAttribute("allQuestions", repo.getAllQuestions());
		return "question";
	}
	
	@RequestMapping("selectedQuestions")
	public String getSelectedQuestions(Model model) {
		model.addAttribute("selectedQuestions", repo.getSelectedQuestions());
		return "exam";
	}
	
	@RequestMapping(value = "InsertQuestion", method = RequestMethod.POST)
	public String InsertQuestion(@RequestParam String questiontextin,@RequestParam Integer classroom_id,
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
	

	@RequestMapping(value = "DeleteQuestion{question_id}", method = RequestMethod.DELETE)
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
	
	// REST end-points - output questions to json - not really used atm but maybe future use
	// curl http://localhost:8080/AppFrmWrk_Project/question/allQuestions.json
	@RequestMapping(value = { "allQuestions", "/" }, method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Question> getAllQuestions() {
		return repo.getAllQuestions();
	}
}
