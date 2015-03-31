package ie.aidan.dao;

import ie.aidan.domain.ClassRoom;

import java.util.List;

// This is the interface class which we will implement for JDBS interaction
public interface ClassRoomRepository {
	void insert(ClassRoom newClass);
	List<ClassRoom> getAllClassRooms();
	void delete(Integer classroom_id);
	ClassRoom findByClassId(Integer classroom_id);
	void select(ClassRoom classRoom);
	void setAllToUnSelected();
}
