package com.k12mate.ex02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

import android.os.Bundle;

public class AlphaKeyboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_keyboard);

        EditText editText=(EditText) findViewById(R.id.editText1);
        MyAlphabetKeyboard alphaKeyboard=(MyAlphabetKeyboard) findViewById(R.id.myalphakeyboard);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        InputConnection ic=editText.onCreateInputConnection(new EditorInfo());
        alphaKeyboard.setInputConection(ic);
    }
}