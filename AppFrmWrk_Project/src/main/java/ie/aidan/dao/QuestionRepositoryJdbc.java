package ie.aidan.dao;

import ie.aidan.domain.Question;

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
public class QuestionRepositoryJdbc implements QuestionRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public QuestionRepositoryJdbc(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Question newquestion) {
		jdbcTemplate.update("insert into question(classroom_id, questiontext, answer1, answer2, "
				+ "answer3, answer4, correctanswer) values(?,?,?,?,?,?,?)",
				newquestion.getClassroom_id(),newquestion.getQuestiontext(),newquestion.getAnswer1(),
				newquestion.getAnswer2(),newquestion.getAnswer3(),newquestion.getAnswer4(),
				newquestion.getCorrectanswer());

	}

	public List<Question> getAllQuestions() {
		return jdbcTemplate.query("select question_id, classroom_id, questiontext, answer1, answer2, "
				+ "answer3, answer4, correctanswer, isselected from question ORDER BY question_id;",
				new QuestionRowMapper());
	}

	public void delete(Integer question_id) {
		jdbcTemplate.update("delete from question where question_id=?", question_id);
	}

	public Question findByQuestionId(Integer question_id) {
		return jdbcTemplate.queryForObject(
				"select question_id, classroom_id, questiontext, answer1, answer2, "
				+ "answer3, answer4, correctanswer, isselected from student where question_id=?",
				new QuestionRowMapper(), question_id);
	}

	public void select(Question question) {
		jdbcTemplate.update("update student set isselected=? where question_id=?",
				question.isIsselected(), question.getQuestion_id());

	}

	public void setAllToUnSelected() {
		jdbcTemplate.update("update question set isselected=false");
	}

	public List<Question> getSelectedQuestions() {
		return jdbcTemplate.query("select  question.question_id, question.classroom_id, "
				+ "question.questiontext, question.answer1, question.answer2, "
				+ "question.answer3, question.answer4, question.correctanswer, question.isselected "
				+ "FROM question INNER JOIN classroom ON classroom.isselected='true' "
				+ "and classroom.classroom_id=question.classroom_id ORDER BY question.question_id;",
				new QuestionRowMapper());
	}

	public boolean CheckIfQuestionExists(String question_text) {
		if (jdbcTemplate.queryForObject(
				"select question_id where questiontext=?",
				new QuestionRowMapper(), question_text) == null)
				{
					return false;
				}
				else
				{
					return true;
				}
	}

}

class QuestionRowMapper implements RowMapper<Question> {

	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				
		int question_id = rs.getInt("question_id");
		int classroom_id = rs.getInt("classroom_id");
		String questiontext = rs.getString("questiontext");
		String answer1 = rs.getString("answer1");
		String answer2 = rs.getString("answer2");
		String answer3 = rs.getString("answer3");
		String answer4 = rs.getString("answer4");
		int correctanswer = rs.getInt("correctanswer");
		boolean isselected = rs.getBoolean("isselected");
		Question question = new Question();
		question.setQuestion_id(question_id);
		question.setClassroom_id(classroom_id);
		question.setQuestiontext(questiontext);
		question.setAnswer1(answer1);
		question.setAnswer2(answer2);
		question.setAnswer3(answer3);
		question.setAnswer4(answer4);
		question.setCorrectanswer(correctanswer);
		question.setIsselected(isselected);
		return question;
	}
}