package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SinPatas extends AppCompatActivity {

    private String nameM;
    ArrayList<String> names;
    TextView tname;
    Button lisos, concosas;
    String[] measureData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_patas);

        tname = (TextView)findViewById(R.id.textViewName6);
        lisos = (Button)findViewById(R.id.lisos);
        concosas = (Button)findViewById(R.id.concosas);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);

    }

    public void Lisos(View view){
        Intent i = new Intent(this,Lisos.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void ConCosas(View view){
        Intent i = new Intent(this,ConCosas.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }


}


