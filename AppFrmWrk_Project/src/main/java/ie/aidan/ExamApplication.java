package ie.aidan;

import ie.aidan.dao.ClassRoomRepository;
import ie.aidan.domain.ClassRoom;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamApplication {
	public static void main(String[] args) {
		
		// Example of getting bean from xml file and just outputting to the console
		// Doesn't really add much to this application but a good example
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ClassRoomRepository classRoomRepository = ctx.getBean(ClassRoomRepository.class); //note its the interface type (classRepository) - generic
		List<ClassRoom> all = classRoomRepository.getAllClassRooms();
		System.out.println("Output from ExamApplication");
		System.out.println(all);
		
	}

}
