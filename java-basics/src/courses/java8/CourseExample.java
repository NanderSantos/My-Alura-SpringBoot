package courses.java8;

import java.util.*;
import java.util.stream.Collectors;

public class CourseExample {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Python", 45));
        courses.add(new Course("JavaScript", 150));
        courses.add(new Course("Java 8", 113));
        courses.add(new Course("C", 55));

        courses.sort(Comparator.comparingInt(Course::getStudents));
        courses.forEach(course -> System.out.println(course.getName()));

        int sum = courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .mapToInt(Course::getStudents)
                .sum();

        System.out.println("Soma: " + sum);

        Optional<Course> optional = courses.stream()
                .filter(course -> course.getStudents() >= 1000)
                .findAny();

        optional.ifPresent(course -> System.out.println("Curso com mais de 100 alunos: " + course.getName()));

        courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .findAny()
                .ifPresent(course -> System.out.println("Curso com mais de 100 alunos: " + course.getName()));

        courses.stream()
                .mapToInt(Course::getStudents)
                .average()
                .ifPresent(value -> System.out.println("Média de alunos: " + value));

        List<Course> collect = courses.stream()
                .filter(course -> course.getStudents() >= 100)
                .collect(Collectors.toList());

        collect.forEach(course -> System.out.println("collect: " + course.getName()));

        courses.stream()
                .collect(Collectors.toMap(Course::getName, Course::getStudents))
                .forEach((course, students) -> System.out.println(course + ": " + students));


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

    public void setName(String name) {
        this.name = name;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }
}