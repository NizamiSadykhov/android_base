package com.nizamisadykhov.androidbase.model;

import android.util.Log;

import com.nizamisadykhov.androidbase.constants.OperationType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private static Calculator INSTANCE;
    private static final String LOG_TAG = Calculator.class.getName();
    private static final double DEFAULT_VALUE = 0.0;


    private BigDecimal mValueOne = BigDecimal.valueOf(DEFAULT_VALUE);
    private BigDecimal mValueTwo = BigDecimal.valueOf(DEFAULT_VALUE);
    private OperationType mTypeOperation = OperationType.NOTHING;

    private Calculator() {
    }

    public void setValueOne(String value) {
        try {
            double valueOfDouble = Double.parseDouble(value.replace(",", "."));
            mValueOne = BigDecimal.valueOf(valueOfDouble);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void setValueTwo(String value) {
        try {
            double valueOfDouble = Double.parseDouble(value.replace(",", "."));
            mValueTwo = BigDecimal.valueOf(valueOfDouble);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void setTypeOperation(OperationType typeOperation) {
        mTypeOperation = typeOperation;
    }

    public OperationType getTypeOperation() {
        return mTypeOperation;
    }

    public double getResult() {
        switch (mTypeOperation){
            case ADDITION:
                return mValueOne.add(mValueTwo).doubleValue();
            case SUBTRACTION:
                return mValueOne.subtract(mValueTwo).doubleValue();
            case MULTIPLICATION:
                return mValueOne.multiply(mValueTwo).doubleValue();
            case DIVISION:
            {
                try {
                    return mValueOne.divide(mValueTwo, RoundingMode.FLOOR).doubleValue();
                } catch (ArithmeticException arithmeticException) {
                    Log.e(LOG_TAG, arithmeticException.getMessage());
                    return DEFAULT_VALUE;
                }
            }
            default:
                return DEFAULT_VALUE;
        }
    }

    public void reset() {
        mValueOne = BigDecimal.valueOf(DEFAULT_VALUE);
        mValueTwo = BigDecimal.valueOf(DEFAULT_VALUE);
        mTypeOperation = OperationType.NOTHING;
    }

    public static Calculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Calculator();
        }
        return INSTANCE;
    }
}
