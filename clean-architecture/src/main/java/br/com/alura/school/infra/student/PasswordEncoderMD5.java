package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoderMD5 implements PasswordEncoder {

    @Override
    public String encodePassword(String password) {

        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            byte[] bytes = md5.digest();

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            return stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not generate password hash!");
        }
    }

    @Override
    public boolean validatePassword(String encodedPassword, String password) {
        return encodedPassword.equals(this.encodePassword(password));
    }
}
