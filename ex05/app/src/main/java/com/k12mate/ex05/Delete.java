package com.k12mate.ex05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {
    Button deleteOk;
    EditText deleteId;
    String id;
    DBHandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        deleteOk = (Button)findViewById(R.id.deleteButton);
        deleteId = (EditText) findViewById(R.id.deleteId);

        dbHandler = new DBHandler(Delete.this);

        deleteOk.setOnClickListener(view -> {
            id = deleteId.getText().toString();
            dbHandler.deleteEntry(id);
            Toast.makeText(Delete.this, "Entry Deleted", Toast.LENGTH_SHORT).show();

            deleteId.setText("");
        });
    }
}