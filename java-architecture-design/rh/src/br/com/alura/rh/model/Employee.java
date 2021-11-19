package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private PersonalDetails personalDetails;
    private LocalDate lastReadjustmentDate;

    public Employee(String name, String cpf, Position position, BigDecimal salary, LocalDate lastAdjustmentDate) {
        this.personalDetails = new PersonalDetails(
                name,
                cpf,
                position,
                salary
        );
        this.lastReadjustmentDate = lastAdjustmentDate;
    }

    public void updateSalary(BigDecimal newSalary) {
        this.personalDetails.setSalary(newSalary);
        this.lastReadjustmentDate = LocalDate.now();
    }

    public void promote(Position newPosition) {
        this.personalDetails.setPosition(newPosition);
    }

    public LocalDate getLastReadjustmentDate() {
        return lastReadjustmentDate;
    }

    public void setLastReadjustmentDate(LocalDate lastReadjustmentDate) {
        this.lastReadjustmentDate = lastReadjustmentDate;
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
