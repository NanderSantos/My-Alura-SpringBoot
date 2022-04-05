package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.infra.student.StudentRepositoryMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnrollStudentServiceTest {

    @Test
    void studentShouldBePersisted() {

        StudentRepositoryMemory studentRepository = new StudentRepositoryMemory();
        EnrollStudentService enrollStudentService = new EnrollStudentService(studentRepository);

        EnrollStudentDto studentDto = new EnrollStudentDto(
                "Fulano de Tal",
                "123.456.789-00",
                "fulano.tal@email.com"
        );

        enrollStudentService.exec(studentDto);

        Student foundedStudent = studentRepository.getByCPF(new CPF("123.456.789-00"));

        Assertions.assertEquals("Fulano de Tal", foundedStudent.getName());
        Assertions.assertEquals("123.456.789-00", foundedStudent.getCpf().getNumber());
        Assertions.assertEquals("fulano.tal@email.com", foundedStudent.getEmail().getAddress());
    }
}
