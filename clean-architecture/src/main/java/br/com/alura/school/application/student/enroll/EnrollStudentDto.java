package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Email;
import br.com.alura.school.domain.student.Student;

public class EnrollStudentDto {

    private String name;
    private String cpf;
    private String email;

    public EnrollStudentDto(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student toStudent() {
        return new Student(
                new CPF(this.cpf),
                this.name,
                new Email(this.email)
        );
    }
}
