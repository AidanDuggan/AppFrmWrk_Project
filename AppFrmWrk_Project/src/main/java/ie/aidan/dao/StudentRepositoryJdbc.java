package ie.aidan.dao;

import ie.aidan.domain.ClassRoom;
import ie.aidan.domain.Student;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentRepositoryJdbc implements StudentRepository{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentRepositoryJdbc(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Student newstudent) {
		// TODO Auto-generated method stub
		
	}

	public List<Student> getAllStudents() {
		return jdbcTemplate.query("select student_id, classroom_id, firstname, lastname, password, "
				+ "dob, isselected from student ORDER BY student_id;",
				new StudentRowMapper());
	}

	public void delete(Integer student_id) {
		// TODO Auto-generated method stub
		
	}

	public Student findByStudentId(Integer student_id) {
		return jdbcTemplate.queryForObject(
				"select student_id, classroom_id, firstname, lastname, password, dob, isselected "
				+ "from student where student_id=?",
				new StudentRowMapper(), student_id);
	}

	public void select(Student student) {
		jdbcTemplate.update("update student set isselected=? where student_id=?",
				student.isIsselected(), student.getStudent_id());
	}

	public void setAllToUnSelected() {
		jdbcTemplate.update("update student set isselected=false");
	}

	public List<Student> getSelectedStudents() {
		return jdbcTemplate.query("select student.student_id,  student.classroom_id, student.firstname, "
				+ "student.lastname, student.password, student.dob, student.isselected "
				+ "FROM student INNER JOIN classroom ON classroom.isselected='true' "
				+ "and classroom.classroom_id=student.classroom_id ORDER BY student.student_id;",
				new StudentRowMapper());
	}

}

class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int student_id = rs.getInt("student_id");
		int classroom_id = rs.getInt("classroom_id");
		String firstname = rs.getString("firstname");
		String lastname = rs.getString("lastname");
		String password = rs.getString("password");
		Date  dob = rs.getDate("dob");
		boolean isselected = rs.getBoolean("isselected");
		Student student = new Student();
		student.setStudent_id(student_id);
		student.setClassRoom_id(classroom_id);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setDob(dob);
		student.setPassword(password);
		student.setIsselected(isselected);
		return student;
	}
}
