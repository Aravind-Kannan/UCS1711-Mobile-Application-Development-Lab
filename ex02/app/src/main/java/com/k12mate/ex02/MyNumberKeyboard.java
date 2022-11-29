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

public class MyNumberKeyboard extends LinearLayout implements View.OnClickListener {
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,be,bd;
    private SparseArray<String> keyValues=new SparseArray<>();
    private InputConnection inputConnection;

    public MyNumberKeyboard(Context context) {
        this(context,null,0);
    }

    public MyNumberKeyboard(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyNumberKeyboard(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.my_number_keyboard,this,true);
        b1= (Button) findViewById(R.id.button_1);
        b1.setOnClickListener(this);
        b2= (Button) findViewById(R.id.button_2);
        b2.setOnClickListener(this);
        b3= (Button) findViewById(R.id.button_3);
        b3.setOnClickListener(this);
        b4= (Button) findViewById(R.id.button_4);
        b4.setOnClickListener(this);
        b5= (Button) findViewById(R.id.button_5);
        b5.setOnClickListener(this);
        b6= (Button) findViewById(R.id.button_6);
        b6.setOnClickListener(this);
        b7= (Button) findViewById(R.id.button_7);
        b7.setOnClickListener(this);
        b8= (Button) findViewById(R.id.button_8);
        b8.setOnClickListener(this);
        b9= (Button) findViewById(R.id.button_9);
        b9.setOnClickListener(this);
        b0= (Button) findViewById(R.id.button_0);
        b0.setOnClickListener(this);
        be= (Button) findViewById(R.id.button_enter);
        be.setOnClickListener(this);
        bd= (Button) findViewById(R.id.button_delete);
        bd.setOnClickListener(this);

        keyValues.put(R.id.button_1,"1");
        keyValues.put(R.id.button_2,"2");
        keyValues.put(R.id.button_3,"3");
        keyValues.put(R.id.button_4,"4");
        keyValues.put(R.id.button_5,"5");
        keyValues.put(R.id.button_6,"6");
        keyValues.put(R.id.button_7,"7");
        keyValues.put(R.id.button_8,"8");
        keyValues.put(R.id.button_9,"9");
        keyValues.put(R.id.button_0,"0");
        keyValues.put(R.id.button_enter,"\n");
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