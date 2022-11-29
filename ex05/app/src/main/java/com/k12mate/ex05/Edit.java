package com.k12mate.ex05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Edit extends AppCompatActivity {

    Button back_btn, submit_btn;
    EditText country, phone, email, name;
    private DBHandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        Intent intent = getIntent();

        String str = intent.getStringExtra("info");

        String []splitString = str.split(":");

        back_btn =(Button)findViewById(R.id.editBack);
        submit_btn =(Button)findViewById(R.id.editSubmit);

        name =(EditText) findViewById(R.id.editName1);
        country =(EditText)findViewById(R.id.editAddress);
        phone =(EditText)findViewById(R.id.editPhone);
        email =(EditText)findViewById(R.id.editEmail);

        name.setText(splitString[1]);
        country.setText(splitString[2]);
        phone.setText(splitString[3]);
        email.setText(splitString[4]);

        dbHandler = new DBHandler(Edit.this);

        back_btn.setOnClickListener(view -> goBack());

        submit_btn.setOnClickListener(view -> {
            String name_str= name.getText().toString();
            String country_str= country.getText().toString();
            String phone_str= phone.getText().toString();
            String email_str= email.getText().toString();

            if(name_str.isEmpty()) {
                Toast.makeText(Edit.this, "Please enter the name", Toast.LENGTH_SHORT).show();
                return;
            } else if(country_str.isEmpty()) {
                Toast.makeText(Edit.this, "Please enter the address", Toast.LENGTH_SHORT).show();
                return;
            } else if(phone_str.isEmpty()) {
                Toast.makeText(Edit.this, "Please enter the phone no.", Toast.LENGTH_SHORT).show();
                return;
            } else if(email_str.isEmpty()) {
                Toast.makeText(Edit.this, "Please enter the email", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHandler.updateInfo(splitString[0], name_str,country_str,phone_str,email_str);
            Toast.makeText(Edit.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

            goBack();
        });
    }

    public void goBack() {
        Intent intent = new Intent(this,Update.class);
        startActivity(intent);
    }
}