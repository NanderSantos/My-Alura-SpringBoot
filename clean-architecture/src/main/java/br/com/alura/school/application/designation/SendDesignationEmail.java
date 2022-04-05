package br.com.alura.school.application.designation;

import br.com.alura.school.domain.student.Student;

public interface SendDesignationEmail {

    void sendTo(Student designetedStudent);
}
