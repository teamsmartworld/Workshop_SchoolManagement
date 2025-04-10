package se.lexicon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    // Constructor
    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Method to register a student to the course
    public void register(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println(student.getName() + " has been registered to " + courseName);
        } else {
            System.out.println(student.getName() + " is already registered to this course.");
        }
    }

    // Method to unregister a student from the course
    public void unregister(Student student) {
        if (students.remove(student)) {
            System.out.println(student.getName() + " has been unregistered from " + courseName);
        } else {
            System.out.println(student.getName() + " is not registered in this course.");
        }
    }

    // Optional: toString for easier display
    @Override
    public String toString() {
        return "Course{id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students.size() + '}';
    }

    public void setCourseName(String s) {
    }

    public void setStartDate(LocalDate parse) {
    }

    public void setWeekDuration(int i) {
    }
}

