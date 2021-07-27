package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SinCasa extends AppCompatActivity {

    private String nameM;
    ArrayList<String> names;
    TextView tname;
    Button conpatas, sinpatas;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_casa);

        tname = (TextView)findViewById(R.id.textViewName5);
        conpatas = (Button)findViewById(R.id.conpatas);
        sinpatas = (Button)findViewById(R.id.sinpatas);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);

    }

    public void ConPatas(View view){
        Intent intent = new Intent(this,ConPatas.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }

    public void SinPatas(View view){
        Intent intent = new Intent(this,SinPatas.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }

}