package com.k12mate.ex05;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button insert_btn, delete_btn, display_btn, edit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert_btn =(Button)findViewById(R.id.insert);
        delete_btn =(Button)findViewById(R.id.delete);
        display_btn =(Button)findViewById(R.id.display);
        edit_btn =(Button)findViewById(R.id.edit);

        insert_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Insert.class);
            startActivity(intent);
        });

        display_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Display.class);
            startActivity(intent);
        });

        delete_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Delete.class);
            startActivity(intent);
        });

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditActivity();
            }
        });
    }

    public void openEditActivity() {
        Intent intent = new Intent(this, Update.class);
        startActivity(intent);
    }
}