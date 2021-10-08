package br.com.alura.store.model;

import javax.persistence.Entity;

@Entity
public class Computing extends Product {

    private String brand;
    private Integer model;

    public Computing() {
    }

    public Computing(String brand, Integer model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}
