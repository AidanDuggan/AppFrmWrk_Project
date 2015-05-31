package ie.aidan.web;

import ie.aidan.dao.ClassRoomRepository;
import ie.aidan.domain.ClassRoom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
/*The @Controller annotation indicates that a particular class serves the role of a controller. 
There is no need to extend any controller base class or reference the Servlet API. 
You are of course still able to reference Servlet-specific features if you need to.
The basic purpose of the @Controller annotation is to act as a stereotype for the annotated class, indicating its role. 
The dispatcher will scan such annotated classes for mapped methods, detecting @RequestMapping annotations.
Annotated controller beans may be defined explicitly, using a standard Spring bean definition in the dispatcher's 
context. However, the @Controller stereotype also allows for autodetection, aligned with Spring 2.5's 
general support for detecting component classes in the classpath and auto-registering bean definitions for them.
To enable autodetection of such annotated controllers, you have to add component scanning to your configuration
*/
public class ClassRoomController {

	@Autowired
	private ClassRoomRepository repo;

	@RequestMapping("classrooms")
	public String getAllClassRooms(Model model) {
		model.addAttribute("classrooms", repo.getAllClassRooms());
		return "classroom";
	}
	/*
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String create(@RequestParam String classRoomName) {
		ClassRoom classRoom = new ClassRoom();
		// TODO - must add logic / change DB to generate next unique ID
		// - must also add teacher name
		classRoom.setclass_name(classRoomName);
		repo.insert(classRoom);
		return "redirect:all";
	}
	*/


	@RequestMapping(value = "SelectClass{classroom_id}", method = RequestMethod.POST)
	public String selectClassRoom(@PathVariable Integer classroom_id) {
		repo.setAllToUnSelected();
		ClassRoom classRoom = repo.findByClassId(classroom_id);
		classRoom.setIsselected(true);
		repo.select(classRoom);
		return "redirect:selectedStudents"; // For some reason the browser does not refresh automatically !!
		//return "redirect:classrooms";
	}
	
	@RequestMapping(value = "ClassRoomPage", method = RequestMethod.GET)
	 public String ClassRoomPage() {
    
		 return "redirect:classrooms";
	 }
	 @RequestMapping(value = "StudentPage", method = RequestMethod.GET)
	 public String StudentPage() {
    
		 return "redirect:selectedStudents";
	 }
	 @RequestMapping(value = "QuestionPage", method = RequestMethod.GET)
	 public String QuestionPage() {
    
		 return "redirect:allQuestions";
	 }	 
	 
/*
	@RequestMapping(value = "{classRoom_id}, {teacher_id}", method = RequestMethod.PUT)
	public String updateTeacher(@PathVariable Integer classRoom_id, @PathVariable Integer teacher_id) {
		ClassRoom classRoom = repo.findByClassId(classRoom_id);
		classRoom.setteacher_id(teacher_id);
		repo.update(classRoom);
		return "redirect:all";
	}
	*/
	/*
	@RequestMapping(value = "{classroom_id}", method = RequestMethod.PUT)
	public String updateSelected( @PathVariable Integer classroom_id) {
		repo.SetAllToUnSelected();
		ClassRoom classRoom = repo.findByClassId(classroom_id);
		classRoom.setIsselected(true);
		repo.update(classRoom);
		//repo.delete(classroom_id);
		//return "redirect:students";
		return "redirect:classRooms";
	}
	*/
}
