package ie.aidan.dao;

import ie.aidan.domain.Class;
import java.util.List;

public interface ClassRepository {
	void insert(Class newClass);
	List<Class> getAll();
}
