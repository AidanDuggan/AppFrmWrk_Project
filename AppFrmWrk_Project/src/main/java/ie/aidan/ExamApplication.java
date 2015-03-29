package ie.aidan;

import ie.aidan.dao.ClassRepository;
import ie.aidan.domain.Class;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");
		ClassRepository todoRepository = ctx.getBean(ClassRepository.class); //note its the interface type (TodoRepository) - generic

		List<Class> all = todoRepository.getAll();
		System.out.println(all);
	}

}
