package se.lexicon;

// StudentDaoImpl class
import java.util.ArrayList;
import java.util.List;

class StudentDaoImpl implements StudentDao {
    private List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }
}