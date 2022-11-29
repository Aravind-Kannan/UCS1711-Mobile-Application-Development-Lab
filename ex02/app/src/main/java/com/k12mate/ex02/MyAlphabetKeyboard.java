package com.k12mate.ex02;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.Button;

public class MyAlphabetKeyboard extends LinearLayout implements View.OnClickListener {
    private Button[] b = new Button[29];
    private SparseArray<String> keyValues=new SparseArray<>();
    private InputConnection inputConnection;

    public MyAlphabetKeyboard(Context context) {
        this(context,null,0);
    }

    public MyAlphabetKeyboard(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyAlphabetKeyboard(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.my_alphabet_keyboard,this,true);

        int[] resources = {
                R.id.button_a, R.id.button_b, R.id.button_c, R.id.button_d, R.id.button_e,
                R.id.button_f, R.id.button_g, R.id.button_h, R.id.button_i, R.id.button_j,
                R.id.button_j, R.id.button_k, R.id.button_l, R.id.button_m, R.id.button_n,
                R.id.button_o, R.id.button_p, R.id.button_q, R.id.button_r, R.id.button_s,
                R.id.button_t, R.id.button_u, R.id.button_v, R.id.button_w, R.id.button_x,
                R.id.button_y, R.id.button_z, R.id.button_enter, R.id.button_space, R.id.button_delete
        };

        String[] character = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", "\n", "\b"
        };

        for(int i = 0; i < 29; i++){
            b[i] = (Button) findViewById(resources[i]);
            b[i].setOnClickListener(this);
            keyValues.put(resources[i],character[i]);
        }
    }

    @Override
    public void onClick(View view) {
        if(inputConnection == null) return;

        if(view.getId() == R.id.button_delete) {
            CharSequence selectedText=inputConnection.getSelectedText(0);
            if(TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1,0);
            } else {
                inputConnection.commitText("",1);
            }
        } else {
            String value=keyValues.get(view.getId());
            inputConnection.commitText(value,1);
        }
    }

    public void setInputConection(InputConnection ic) {
        inputConnection=ic;
    }
}