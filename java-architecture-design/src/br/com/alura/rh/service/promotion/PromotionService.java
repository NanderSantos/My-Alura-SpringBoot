package br.com.alura.rh.service.promotion;

import br.com.alura.rh.ValidationException;
import br.com.alura.rh.model.Employee;
import br.com.alura.rh.model.Position;

public class PromotionService {

    public void promote(Employee employee, boolean goalHitted) {

        Position actualPosition =employee.getPosition();

        if(actualPosition == Position.MANAGER) {
            throw new ValidationException("Gerentes não podem ser promovidos");
        }

        if(!goalHitted) {
            throw new ValidationException("Funcionário não bateu a meta para ser promovido!");
        }

        Position newPosition = actualPosition.getNextPosition();
        employee.promote(newPosition);
    }
}
