package se.lexicon;

// CourseDaoImpl class
import java.util.ArrayList;
import java.util.List;

class CourseDaoImpl implements CourseDao {
    private List<Course> courses = new ArrayList<>();

    @Override
    public void save(Course course) {
        courses.add(course);
    }

    @Override
    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public void delete(Course course) {
        courses.remove(course);
    }
}