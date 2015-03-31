package ie.aidan.dao;

import ie.aidan.domain.Student;

import java.util.List;

// This is the interface student which we will implement for JDBS interaction
public interface StudentRepository {
	void insert(Student newstudent);
	List<Student> getAllStudents();
	void delete(Integer student_id);
	Student findByStudentId(Integer student_id);
	void select(Student student);
	void setAllToUnSelected();
	List<Student> getSelectedStudents();
}
