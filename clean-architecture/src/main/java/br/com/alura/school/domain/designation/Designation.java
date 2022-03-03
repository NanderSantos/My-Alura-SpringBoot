package br.com.alura.school.domain.designation;

import br.com.alura.school.domain.student.Student;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Designation {

    private Student designate;
    private Student nominator;
    private LocalDateTime designationDate;

    public Designation(Student designate, Student nominator) {
        this.designate = designate;
        this.nominator = nominator;
        this.designationDate = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

    public Student getDesignate() {
        return designate;
    }

    public Student getNominator() {
        return nominator;
    }

    public LocalDateTime getDesignationDate() {
        return designationDate;
    }
}
