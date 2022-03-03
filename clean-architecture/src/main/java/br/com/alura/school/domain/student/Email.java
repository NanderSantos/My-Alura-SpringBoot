package br.com.alura.school.domain.student;

public class Email {

    private String address;

    public Email(String address) {

        if (address == null || !address.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid e-mail!");
        }

        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
