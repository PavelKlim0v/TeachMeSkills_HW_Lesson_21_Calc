package com.teachmeskills.lesson_21.calc.service;

import com.teachmeskills.lesson_21.calc.entity.Operation;
import com.teachmeskills.lesson_21.calc.entity.User;
import com.teachmeskills.lesson_21.calc.storage.OperationStorage;
import java.util.List;

public class CalcService {

    private static final OperationStorage operationStorage = new OperationStorage();

    public List<Operation> findAll() {
        return operationStorage.getAll();
    }

    public Operation calc(double a, double b, String operand, User user) {
        switch (operand) {
            case "sum": {
                Operation operation = new Operation(a, b, operand, a + b, user);
                operationStorage.save(operation);
                return operation;
            }
            case "sub": {
                Operation operation = new Operation(a, b, operand, a -b, user);
                operationStorage.save(operation);
                return operation;
            }
        }
        return null;
    }

}
