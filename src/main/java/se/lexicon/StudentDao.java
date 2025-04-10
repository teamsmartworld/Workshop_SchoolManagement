package se.lexicon;

// StudentDao interface
import java.util.List;

interface StudentDao {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void delete(Student student);
}