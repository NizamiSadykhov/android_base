package com.nizamisadykhov.androidbase.constants;

public enum OperationType {

    ADDITION(OperationConstants.PLUS),
    SUBTRACTION(OperationConstants.MINUS),
    MULTIPLICATION(OperationConstants.MULTIPLICATION),
    DIVISION(OperationConstants.DIVISION),
    NOTHING("");

    private final String mValue;

    OperationType(String value) {
        mValue = value;
    }

    public static OperationType getOperationTypeByValue(String value) {
        switch (value) {
            case OperationConstants.PLUS:
                return ADDITION;
            case OperationConstants.MINUS:
                return SUBTRACTION;
            case OperationConstants.MULTIPLICATION:
                return MULTIPLICATION;
            case OperationConstants.DIVISION:
                return DIVISION;
            default:
                return NOTHING;
        }
    }
}

