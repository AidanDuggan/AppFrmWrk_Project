package ie.aidan.web;

import ie.aidan.dao.ClassRoomRepository;
import ie.aidan.domain.ClassRoom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
// Note: This test servlet is not really needed in this application but just put in as an example of how
// it works and can be used if needed. It just puts out the contents of class
// load from: http://localhost:8080/AppFrmWrk_Project/testservlet
// Aidan: maybe use it to output the results of exam?

public class TestServlet extends HttpServlet {

	private ClassRoomRepository classRoomRepository;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		classRoomRepository = ctx.getBean(ClassRoomRepository.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String msg = String.format("Output from TestServlet. Current time is: %s", new Date().toString());
		writer.println(msg);
		writer.close();

		List<ClassRoom> all = classRoomRepository.getAllClassRooms();
		System.out.println("Output from TestServlet");
		System.out.println(all);

	}
}
