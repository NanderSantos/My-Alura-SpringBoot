package br.com.alura.store.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonalDetails implements Serializable {

    private String name;
    private String cpf;

    public PersonalDetails() {
    }

    public PersonalDetails(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
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
}
