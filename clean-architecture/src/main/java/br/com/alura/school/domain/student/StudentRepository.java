package br.com.alura.school.domain.student;

import java.util.List;

public interface StudentRepository {

    void enroll(Student student);
    Student getByCPF(CPF cpf);
    List<Student> listAllStudentsEnrolled();
}
