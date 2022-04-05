package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {

        try {

            String sql = "INSERT INTO student VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getCpf().getNumber());
            preparedStatement.setString(2,  student.getName());
            preparedStatement.setString(3,  student.getEmail().getAddress());

            preparedStatement.execute();

            sql = "INSERT INTO phone VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            for (var phone: student.getPhones()) {
                preparedStatement.setString(1, phone.getDdd());
                preparedStatement.setString(1, phone.getNumber());
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getByCPF(CPF cpf) {

        try {

            String sql = "SELECT id, nome email FROM student WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean find = resultSet.next();

            if (!find) {
                throw new StudentNotFoundException(cpf);
            }

            String name = resultSet.getString("name");
            Email email = new Email(resultSet.getString("email"));
            Student student = new Student(cpf, name, email);

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, number FROM phone WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ddd = resultSet.getString("ddd");
                String number = resultSet.getString("number");
                student.addPhone(ddd, number);
            }

            return student;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAllStudentsEnrolled() {

        List<Student> students = new ArrayList<>();

        try {

            String sql = "SELECT id, cpf, nome, email FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                CPF cpf = new CPF(resultSet.getString("cpf"));
                Email email = new Email(resultSet.getString("email"));
                Student student = new Student(cpf, name, email);

                Long id = resultSet.getLong("id");

                sql = "SELECT ddd, number FROM phone WHERE student_id = ?";
                PreparedStatement preparedStatementPhone = connection.prepareStatement(sql);
                preparedStatementPhone.setLong(1, id);

                ResultSet resultSetPhone = preparedStatementPhone.executeQuery();

                while (resultSetPhone.next()) {
                    String ddd = resultSetPhone.getString("ddd");
                    String number = resultSetPhone.getString("number");
                    student.addPhone(ddd, number);
                }

                students.add(student);
            }

            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
