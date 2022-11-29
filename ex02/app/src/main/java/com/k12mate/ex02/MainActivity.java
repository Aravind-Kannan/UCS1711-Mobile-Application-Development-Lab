package com.k12mate.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText=(EditText) findViewById(R.id.editText);
        alpha = (Button) findViewById(R.id.alpha);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Going to Alpha");
                goToAlphaBoard();
            }
        });

        MyNumberKeyboard numberKeyboard=(MyNumberKeyboard) findViewById(R.id.mynumberkeyboard);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        InputConnection ic=editText.onCreateInputConnection(new EditorInfo());
        numberKeyboard.setInputConection(ic);
    }

    public void goToAlphaBoard() {
        Intent intent = new Intent(this,AlphaKeyboard.class);
        startActivity(intent);
    }
}