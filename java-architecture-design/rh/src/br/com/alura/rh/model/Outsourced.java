package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Outsourced {

    private PersonalDetails personalDetails;
    private String company;

    public Outsourced(String name, String cpf, Position position, BigDecimal salary, String company) {
        this.personalDetails = new PersonalDetails(
                name,
                cpf,
                position,
                salary
        );
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public String getName() {
        return this.personalDetails.getName();
    }

    public void setName(String name) {
        this.personalDetails.setName(name);
    }

    public String getCpf() {
        return this.personalDetails.getCpf();
    }

    public void setCpf(String cpf) {
        this.personalDetails.setCpf(cpf);
    }

    public Position getPosition() {
        return this.personalDetails.getPosition();
    }

    public void setPosition(Position position) {
        this.personalDetails.setPosition(position);
    }

    public BigDecimal getSalary() {
        return this.personalDetails.getSalary();
    }

    public void setSalary(BigDecimal salary) {
        this.personalDetails.setSalary(salary);
    }
}
