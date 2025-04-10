package se.lexicon;

// CLI for school management
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static StudentDao studentDao = new StudentDaoImpl();
    private static CourseDao courseDao = new CourseDaoImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== School Management CLI =====");
            System.out.println("1. Create new student");
            System.out.println("2. Create new course");
            System.out.println("3. Register student to course");
            System.out.println("4. Unregister student from course");
            System.out.println("5. Search for student");
            System.out.println("6. Search for course");
            System.out.println("7. Edit student");
            System.out.println("8. Edit course");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> createStudent();
                case 2 -> createCourse();
                case 3 -> registerStudentToCourse();
                case 4 -> unregisterStudentFromCourse();
                case 5 -> searchStudent();
                case 6 -> searchCourse();
                case 7 -> editStudent();
                case 8 -> editCourse();
                case 9 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void createStudent() {
        System.out.print("Enter student id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        studentDao.save(new Student(id, name, email, address));
        System.out.println("Student created.");
    }

    private static void createCourse() {
        System.out.print("Enter course id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter duration in weeks: ");
        int duration = Integer.parseInt(scanner.nextLine());

        courseDao.save(new Course(id, name, startDate, duration));
        System.out.println("Course created.");
    }

    private static void registerStudentToCourse() {
        System.out.print("Enter course id: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student id: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        Course course = courseDao.findById(courseId);
        Student student = studentDao.findById(studentId);

        if (course != null && student != null) {
            course.register(student);
            System.out.println("Student registered to course.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private static void unregisterStudentFromCourse() {
        System.out.print("Enter course id: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student id: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        Course course = courseDao.findById(courseId);
        Student student = studentDao.findById(studentId);

        if (course != null && student != null) {
            course.unregister(student);
            System.out.println("Student removed from course.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentDao.findById(id);
        System.out.println(student != null ? student : "Student not found.");
    }

    private static void searchCourse() {
        System.out.print("Enter course id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Course course = courseDao.findById(id);
        System.out.println(course != null ? course : "Course not found.");
    }

    private static void editStudent() {
        System.out.print("Enter student id to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentDao.findById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new name: ");
        student.setName(scanner.nextLine());
        System.out.print("Enter new email: ");
        student.setEmail(scanner.nextLine());
        System.out.print("Enter new address: ");
        student.setAddress(scanner.nextLine());
        System.out.println("Student updated.");
    }

    private static void editCourse() {
        System.out.print("Enter course id to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Course course = courseDao.findById(id);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter new course name: ");
        course.setCourseName(scanner.nextLine());
        System.out.print("Enter new start date (YYYY-MM-DD): ");
        course.setStartDate(LocalDate.parse(scanner.nextLine()));
        System.out.print("Enter new week duration: ");
        course.setWeekDuration(Integer.parseInt(scanner.nextLine()));
        System.out.println("Course updated.");
    }
}