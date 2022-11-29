package com.k12mate.ex05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {

    Button updateOk;
    EditText updateId;
    String id;

    DBHandler dbHandler;
    PersonModel person;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        updateOk = (Button)findViewById(R.id.editButton);
        updateId = (EditText) findViewById(R.id.editId);

        dbHandler = new DBHandler(Update.this);

        updateOk.setOnClickListener(view -> {
            id = updateId.getText().toString();
            person = dbHandler.getIndividualInfo(id);
            if(person ==null)
                Toast.makeText(Update.this, "No such entry", Toast.LENGTH_SHORT).show();
            else
                openEditActivity(person);

        });
    }

    public void openEditActivity(PersonModel info) {
        System.out.println("Trying to open Edit Activity");
        Intent intent = new Intent(this, Edit.class);
        System.out.println(info.getName()+":"+info.getCountry()+":"+info.getPhone()+":"+info.getEmail());
        intent.putExtra("info",info.getId()+":"+info.getName()+":"+info.getCountry()+":"+info.getPhone()+":"+info.getEmail());
        startActivity(intent);
    }
}