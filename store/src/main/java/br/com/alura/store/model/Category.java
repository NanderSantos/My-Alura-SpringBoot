package br.com.alura.store.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @EmbeddedId
    private CategoryId id;

    public Category() {
    }

    public Category(String name) {

        this.id = new CategoryId(name, "XPTO");
    }

    public String getName() {
        return this.id.getName();
    }

    public void setName(String name) {

        this.id.setName(name);
    }
}
