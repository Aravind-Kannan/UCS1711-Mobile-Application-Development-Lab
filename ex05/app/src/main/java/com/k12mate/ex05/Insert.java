package com.k12mate.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    Button back_btn, submit_btn;
    EditText name, address, phone, email;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        back_btn =(Button)findViewById(R.id.back);
        submit_btn =(Button)findViewById(R.id.submit);

        name=(EditText)findViewById(R.id.name1);
        address =(EditText)findViewById(R.id.address);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);

        back_btn.setOnClickListener(view -> goBack());

        dbHandler = new DBHandler(Insert.this);

        submit_btn.setOnClickListener(view -> {
            String name_str = name.getText().toString();
            String address_str = address.getText().toString();
            String phone_str = phone.getText().toString();
            String email_str = email.getText().toString();

            if(name_str.isEmpty()) {
                Toast.makeText(Insert.this, "Please enter the name", Toast.LENGTH_SHORT).show();
                return;
            } else if(address_str.isEmpty()) {
                Toast.makeText(Insert.this, "Please enter the address", Toast.LENGTH_SHORT).show();
                return;
            } else if(phone_str.isEmpty()) {
                Toast.makeText(Insert.this, "Please enter the phone no.", Toast.LENGTH_SHORT).show();
                return;
            } else if(email_str.isEmpty()) {
                Toast.makeText(Insert.this, "Please enter the email", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHandler.addNewEntry(name_str,address_str,phone_str,email_str);
            Toast.makeText(Insert.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();

            name.setText("");
            address.setText("");
            phone.setText("");
            email.setText("");
        });
    }
    public void goBack() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}