package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentNotFoundException;
import br.com.alura.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMemory implements StudentRepository {

    private final List<Student> enrolledStudents = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolledStudents.add(student);
    }

    @Override
    public Student getByCPF(CPF cpf) {
        return this.enrolledStudents
                .stream()
                .filter(student -> student.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(cpf));
    }

    @Override
    public List<Student> listAllStudentsEnrolled() {
        return this.enrolledStudents;
    }
}
