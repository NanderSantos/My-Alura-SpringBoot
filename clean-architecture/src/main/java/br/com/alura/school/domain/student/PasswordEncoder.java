package br.com.alura.school.domain.student;

public interface PasswordEncoder {

    String encodePassword(String password);
    boolean validatePassword(String encodedPassword, String password);
}
