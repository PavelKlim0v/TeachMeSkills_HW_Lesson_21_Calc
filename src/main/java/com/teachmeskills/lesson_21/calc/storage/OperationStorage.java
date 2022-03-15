package com.teachmeskills.lesson_21.calc.storage;

import com.teachmeskills.lesson_21.calc.entity.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationStorage {

    private final List<Operation> operations = new ArrayList<>();

    public List<Operation> getAll() {
        return new ArrayList<>(operations);
    }

    public void save (Operation operation) {
        operations.add(operation);
    }

}
