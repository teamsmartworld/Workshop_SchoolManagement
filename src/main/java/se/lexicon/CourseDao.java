package se.lexicon;

// CourseDao interface
import java.util.List;

interface CourseDao {
    void save(Course course);
    Course findById(int id);
    List<Course> findAll();
    void delete(Course course);
}