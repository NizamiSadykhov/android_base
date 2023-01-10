package com.nizamisadykhov.androidbase.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nizamisadykhov.androidbase.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView mDisplayTextView;
    private CalculatorPresenter mCalculatorPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayTextView = findViewById(R.id.text_view_display);
        mCalculatorPresenter = new CalculatorPresenter(this);
        initInputDigitsButtons();
        initOperationButtons();

        Button floatButton = findViewById(R.id.button_float);
        floatButton.setOnClickListener(view -> {
            String buttonText = floatButton.getText().toString();
            String textOnDisplay = mDisplayTextView.getText().toString();
            mCalculatorPresenter.clickFloatButton(buttonText, textOnDisplay);
        });

        findViewById(R.id.button_equal).setOnClickListener(view -> {
            mCalculatorPresenter.clickEqualButton(mDisplayTextView.getText().toString());
        });

        findViewById(R.id.button_ac).setOnClickListener(view -> {
            mCalculatorPresenter.clickButtonAllClean();
        });
    }

    private void initInputDigitsButtons() {
        int digitButtonsQuantity = 10;
        List<Button> digitsButtons = new ArrayList<>(digitButtonsQuantity);
        digitsButtons.add(findViewById(R.id.button_zero));
        digitsButtons.add(findViewById(R.id.button_one));
        digitsButtons.add(findViewById(R.id.button_two));
        digitsButtons.add(findViewById(R.id.button_three));
        digitsButtons.add(findViewById(R.id.button_four));
        digitsButtons.add(findViewById(R.id.button_five));
        digitsButtons.add(findViewById(R.id.button_six));
        digitsButtons.add(findViewById(R.id.button_seven));
        digitsButtons.add(findViewById(R.id.button_eight));
        digitsButtons.add(findViewById(R.id.button_nine));

        for (Button button: digitsButtons) {
            button.setOnClickListener(view -> {
                String buttonText = button.getText().toString();
                String textOnDisplay = mDisplayTextView.getText().toString();
                mCalculatorPresenter.clickInputDigitButton(buttonText, textOnDisplay);
            });
        }
    }

    private void initOperationButtons() {
        List<Button> operationButton = new ArrayList<>(4);
        operationButton.add(findViewById(R.id.button_plus));
        operationButton.add(findViewById(R.id.button_minus));
        operationButton.add(findViewById(R.id.button_multiply));
        operationButton.add(findViewById(R.id.button_divide));
        for (Button button: operationButton) {
            button.setOnClickListener(view -> {
                String buttonText = button.getText().toString();
                String textOnDisplay = mDisplayTextView.getText().toString();
                mCalculatorPresenter.clickOperationButton(buttonText, textOnDisplay);
            });
        }
    }

    @Override
    public void showResult(String result) {
        mDisplayTextView.setText(result);
    }
}