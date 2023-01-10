package com.nizamisadykhov.androidbase.ui;

import com.nizamisadykhov.androidbase.constants.OperationType;
import com.nizamisadykhov.androidbase.model.Calculator;

public class CalculatorPresenter {

    private final CalculatorView mView;
    private final Calculator mCalculator = Calculator.getInstance();
    private int mStartValueTwoIndex = 0;

    public CalculatorPresenter(CalculatorView calculatorView) {
        mView = calculatorView;
    }

    public void clickInputDigitButton(String buttonText, String textOnDisplay) {
        mView.showResult(textOnDisplay + buttonText);
    }

    public void clickOperationButton(String buttonText, String textOnDisplay) {

        if (mCalculator.getTypeOperation() == OperationType.NOTHING) {
            mCalculator.setValueOne(textOnDisplay);
            OperationType operationType = OperationType.getOperationTypeByValue(buttonText);
            mCalculator.setTypeOperation(operationType);
            String resultText = textOnDisplay + " " + buttonText + " ";
            mStartValueTwoIndex = resultText.length();
            mView.showResult(resultText);
        }
    }

    public void clickEqualButton(String textOnDisplay) {
        if (mCalculator.getTypeOperation() != OperationType.NOTHING) {
            String valueTwo = textOnDisplay.substring(mStartValueTwoIndex);
            mCalculator.setValueTwo(valueTwo);
            double result = mCalculator.getResult();
            mView.showResult(String.valueOf(result).replace('.', ','));
            mCalculator.reset();
            mStartValueTwoIndex = 0;
        }
    }

    public void clickButtonAllClean() {
        mStartValueTwoIndex = 0;
        mCalculator.reset();
        mView.showResult("");
    }

    public void clickFloatButton(String buttonText, String textOnDisplay) {
        String lastValue = textOnDisplay.substring(mStartValueTwoIndex);
        if (lastValue.contains(",")){
            return;
        }
        mView.showResult(textOnDisplay + buttonText);
    }
}
