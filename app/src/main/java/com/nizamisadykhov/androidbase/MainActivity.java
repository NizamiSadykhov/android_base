package com.nizamisadykhov.androidbase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mSelectedDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView mCalendarView = findViewById(R.id.calendar_view);
        mSelectedDateTextView = findViewById(R.id.selected_date_text_view);
        mCalendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String dateText = dayOfMonth + "." + month + "." + year;
            mSelectedDateTextView.setText(dateText);
        });
    }
}