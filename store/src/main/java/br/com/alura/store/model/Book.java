package br.com.alura.store.model;

import javax.persistence.Entity;

@Entity
public class Book extends Product {

    private String author;
    private Integer pageNumbers;

    public Book() {
    }

    public Book(String author, Integer pageNumbers) {
        this.author = author;
        this.pageNumbers = pageNumbers;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(Integer pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
}
