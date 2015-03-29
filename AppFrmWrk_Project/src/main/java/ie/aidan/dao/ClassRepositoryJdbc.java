package ie.aidan.dao;

import ie.aidan.domain.Class;
import ie.aidan.dao.ClassRowMapper;
import ie.aidan.domain.Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ClassRepositoryJdbc implements ClassRepository {

	private JdbcTemplate jdbcTemplate;

	public ClassRepositoryJdbc(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Class newClass) {
		jdbcTemplate.update("insert into class(class_id, name, teacher_id) values(?,?,?)",
				newClass.getclass_id(), newClass.getclass_name(), newClass.getteacher_id());
		
	}

	public List<Class> getAll() {
		return jdbcTemplate.query("select class_id, name, teacher_id from class",
				new ClassRowMapper());
	}
}

class ClassRowMapper implements RowMapper<Class> {

	public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
		int class_id = rs.getInt("class_id");
		String class_name = rs.getString("name");
		int  teacher_id = rs.getInt("teacher_id");
		Class Class = new Class();
		Class.setclass_id(class_id);
		Class.setclass_name(class_name);
		Class.setteacher_id(teacher_id);;
		return Class;
	}

}

