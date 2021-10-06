package courses.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseExample {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Python", 45));
        courses.add(new Course("JavaScript", 150));
        courses.add(new Course("Java 8", 113));
        courses.add(new Course("C", 55));

        courses.sort(Comparator.comparing(Course::getStudents));
        courses.forEach(course -> System.out.println(course.getName()));

        int sum = courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .mapToInt(Course::getStudents)
                .sum();

        System.out.println(sum);
    }
}

class Course {

    private String name;
    private int students;

    public Course(String name, int students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public int getStudents() {
        return students;
    }
}