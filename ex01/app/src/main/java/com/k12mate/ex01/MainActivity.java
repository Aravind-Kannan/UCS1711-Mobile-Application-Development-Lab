package com.k12mate.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private CheckBox english, hindi, tamil;
    private RadioGroup gender;
    private Button pickDateBtn, submitBtn;
    private EditText nameET, addressET, emailET, phoneET;
    private TextView dobTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickDateBtn = findViewById(R.id.button);
        submitBtn = findViewById(R.id.button3);
        nameET = findViewById(R.id.editTextTextPersonName);
        addressET = findViewById(R.id.editTextTextPostalAddress);
        dobTV = findViewById(R.id.textView3);
        emailET = findViewById(R.id.editTextTextEmailAddress);
        phoneET = findViewById(R.id.editTextPhone);
        gender = findViewById(R.id.radioGroup);
        english = findViewById(R.id.checkBox);
        hindi = findViewById(R.id.checkBox3);
        tamil = findViewById(R.id.checkBox4);

        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                @SuppressLint("SetTextI18n")
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            dobTV.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1);
                        },
                        year, month, day);

                datePickerDialog.show();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String form = "Name: " + nameET.getText() + "\n" +
                        "Address: " + addressET.getText() + "\n" +
                        "Email: " + emailET.getText() + "\n" +
                        "Phone: " + phoneET.getText();
                Toast.makeText(MainActivity.this, form, form.length()).show();
                nameET.setText(null);
                addressET.setText(null);
                emailET.setText(null);
                phoneET.setText(null);
                gender.clearCheck();
                english.setChecked(false);
                hindi.setChecked(false);
                tamil.setChecked(false);
            }
        });


    }
}