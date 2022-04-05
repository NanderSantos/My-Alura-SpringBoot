package br.com.alura.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();
    private String password;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void print() {
        System.out.println("Nome: " + this.name);
        System.out.println("CPF: " + this.cpf.getNumber());
        System.out.println("E-mail: " + this.email.getAddress());
        this.phones.forEach(phone -> System.out.println("Telefone: " + phone.getFormattedNumber()));
        System.out.println();
    }

    public void addPhone(String ddd, String number) {
        this.phones.add(new Phone(ddd, number));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
