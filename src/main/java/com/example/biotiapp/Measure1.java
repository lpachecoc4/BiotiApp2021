package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Measure1 extends AppCompatActivity {

    private String nameM;
    ArrayList<String> names;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure1);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        TextView tname;
        tname = (TextView)findViewById(R.id.textViewName);
        tname.setText(nameM);
    }

    public void ConCasa(View view){
        Intent intent = new Intent(this,ConCasas.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);

    }

    public void SinCasa(View view){
        Intent intent = new Intent(this,SinCasa.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }

}