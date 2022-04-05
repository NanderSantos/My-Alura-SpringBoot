package br.com.alura.school.domain.student;

public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public StudentNotFoundException(CPF cpf) {
        super("Student not found with CPF: " + cpf.getNumber());
    }
}
