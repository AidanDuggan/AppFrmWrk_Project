package ie.aidan.dao;

import ie.aidan.domain.ClassRoom;
import ie.aidan.dao.ClassRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

// Implementation of interface to JDBC
@Component
// Indicates that an annotated class is a "component". Such classes are considered as candidates 
// for auto-detection when using annotation-based configuration and classpath scanning.
// @Component is a generic stereotype for any Spring-managed component. @Repository, @Service, and 
// @Controller are specializations of @Component for more specific use cases, for example, in the 
// persistence, service, and presentation layers, respectively.
public class ClassRoomRepositoryJdbc implements ClassRoomRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	//Marks a constructor, field, setter method or config method as to be autowired by 
	//Spring's dependency injection facilities.
	public ClassRoomRepositoryJdbc(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// note: we're not using this at the moment as we manually add the class to db but will be used in future
	public void insert(ClassRoom newClass) {
		jdbcTemplate.update("insert into classroom(classroom_id, name, teacher_id, isselected) values(?,?,?,?)",
				newClass.getclassroom_id(), newClass.getclass_name(), newClass.getteacher_id());		
	}

	public List<ClassRoom> getAllClassRooms() {
		return jdbcTemplate.query("select classroom_id, name, teacher_id, isselected from classroom ORDER BY classroom_id;",
				new ClassRowMapper());
	}
	

	public void delete(Integer classroom_id) {
		jdbcTemplate.update("delete from classroom where classroom_id=?", classroom_id);

	}
	public void setAllToUnSelected() {
		jdbcTemplate.update("update classroom set isselected=false");

	}
	public ClassRoom findByClassId(Integer classroom_id) {
		return jdbcTemplate.queryForObject(
				"select classroom_id, name, teacher_id, isselected from classroom where classroom_id=?",
				new ClassRowMapper(), classroom_id);
	}

	public void select(ClassRoom classRoom) {
		jdbcTemplate.update("update classroom set teacher_id=?, name=?, isselected=? where classroom_id=?",
				classRoom.getteacher_id(), classRoom.getclass_name(), classRoom.isIsselected(), classRoom.getclassroom_id());
	}
}

class ClassRowMapper implements RowMapper<ClassRoom> {

	public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
		int classroom_id = rs.getInt("classroom_id");
		String class_name = rs.getString("name");
		int  teacher_id = rs.getInt("teacher_id");
		boolean isselected = rs.getBoolean("isselected");
		ClassRoom ClassRoom = new ClassRoom();
		ClassRoom.setclassroom_id(classroom_id);
		ClassRoom.setclass_name(class_name);
		ClassRoom.setteacher_id(teacher_id);
		ClassRoom.setIsselected(isselected);
		return ClassRoom;
	}

}

