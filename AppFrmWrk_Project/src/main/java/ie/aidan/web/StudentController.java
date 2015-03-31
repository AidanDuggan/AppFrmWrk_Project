package ie.aidan.web;

import ie.aidan.domain.Student;
import ie.aidan.dao.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository repo;

	@RequestMapping("allstudents")
	public String getAllstudentItems(Model model) {
		model.addAttribute("allstudents", repo.getAllStudents());
		return "student";
	}
	
	@RequestMapping("selectedStudents")
	public String getSelectedStudents(Model model) {
		model.addAttribute("selectedStudents", repo.getSelectedStudents());
		return "student";
	}
	
	// Note: At the moment I have to use POST
	@RequestMapping(value = "Student{student_id}", method = RequestMethod.POST)
	public String selectStudent(@PathVariable Integer student_id) {
		repo.setAllToUnSelected();
		Student Student = repo.findByStudentId(student_id);
		Student.setIsselected(true);
		repo.select(Student);
		//repo.delete(student_id);
		return "redirect:selectedStudents";
	}
	

/*	@RequestMapping(value = "{student_isselected}", method = RequestMethod.PUT)
	public String updateSelected( @PathVariable boolean isselected) {
		Student Student = repo.findByStudentId(1);
		Student.setIsselected(true);
		repo.update(Student);
		return "redirect:students";
	}
	*/
}
