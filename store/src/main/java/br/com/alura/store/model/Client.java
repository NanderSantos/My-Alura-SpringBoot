package br.com.alura.store.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonalDetails personalDetails;

    public Client() {
    }

    public Client(String name, String cpf) {

        this.personalDetails = new PersonalDetails(name, cpf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
