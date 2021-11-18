package br.com.alura.rh.model;

import java.math.BigDecimal;

public class PersonalDetails {

    private String name;
    private String cpf;
    private Position position;
    private BigDecimal salary;

    public PersonalDetails(String name, String cpf, Position position, BigDecimal salary) {
        this.name = name;
        this.cpf = cpf;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
