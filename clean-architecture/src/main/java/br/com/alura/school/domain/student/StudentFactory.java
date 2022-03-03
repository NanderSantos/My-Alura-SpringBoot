package br.com.alura.school.domain.student;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCPFEmail(String name, String cpf, String email) {
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public StudentFactory withPhone(String ddd, String number) {
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create() {
        return this.student;
    }

    public static void main(String[] args) {
        Student student = new StudentFactory()
                .withNameCPFEmail("Fulano da Silva", "111.222.333-44", "fulano@email.com")
                .withPhone("12", "123456789")
                .withPhone("12", "12345678")
                .create();

        student.print();
        student.print();
    }
}
