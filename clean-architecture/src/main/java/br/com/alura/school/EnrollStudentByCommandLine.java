package br.com.alura.school;

import br.com.alura.school.application.student.enroll.EnrollStudentDto;
import br.com.alura.school.application.student.enroll.EnrollStudentService;
import br.com.alura.school.infra.student.StudentRepositoryMemory;

public class EnrollStudentByCommandLine {

    public static void main(String[] args) {

        String name = "Fulano de Tal";
        String cpf = "123.456.789-00";
        String email = "fulano.tal@email.com";

        EnrollStudentDto enrollStudentDto = new EnrollStudentDto(name, cpf, email);

        var studentEnrollService = new EnrollStudentService(new StudentRepositoryMemory());
        studentEnrollService.exec(enrollStudentDto);
    }
}
