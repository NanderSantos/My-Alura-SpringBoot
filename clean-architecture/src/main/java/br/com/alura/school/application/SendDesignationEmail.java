package br.com.alura.school.application;

import br.com.alura.school.domain.student.Student;

public interface SendDesignationEmail {

    void sendTo(Student designetedStudent);
}
