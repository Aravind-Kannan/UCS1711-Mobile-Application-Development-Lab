package com.k12mate.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Display extends AppCompatActivity {

    private ArrayList<PersonModel> dataModelList;
    private DBHandler dbHandler;
    private DisplayAdapter displayAdapter;
    private RecyclerView infoRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        dataModelList = new ArrayList<>();
        dbHandler = new DBHandler(Display.this);

        dataModelList = dbHandler.getInfo();

        displayAdapter = new DisplayAdapter(dataModelList, Display.this);
        infoRV = findViewById(R.id.PersonalInfoRecords);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Display.this, RecyclerView.VERTICAL, false);
        infoRV.setLayoutManager(linearLayoutManager);

        infoRV.setAdapter(displayAdapter);
    }
}