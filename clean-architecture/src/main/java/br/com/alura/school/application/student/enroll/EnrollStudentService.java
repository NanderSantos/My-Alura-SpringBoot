package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.StudentRepository;

public class EnrollStudentService {

    private final StudentRepository studentRepository;

    public EnrollStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void exec(EnrollStudentDto studentDto) {
        this.studentRepository.enroll(studentDto.toStudent());
    }
}
