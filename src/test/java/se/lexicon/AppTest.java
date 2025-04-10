package se.lexicon;

// Unit Testing with JUnit
import java.util.List;

class TestDao {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();

        Student s1 = new Student(1, "Alice", "alice@example.com", "123 Lane");
        studentDao.save(s1);
        assert studentDao.findById(1) == s1;

        Course c1 = new Course(101, "Math", LocalDate.now(), 6);
        courseDao.save(c1);
        assert courseDao.findById(101) == c1;

        c1.register(s1);
        assert c1.getStudents().contains(s1);

        c1.unregister(s1);
        assert !c1.getStudents().contains(s1);

        studentDao.delete(s1);
        assert studentDao.findById(1) == null;

        courseDao.delete(c1);
        assert courseDao.findById(101) == null;

        System.out.println("All tests passed!");
    }
}

