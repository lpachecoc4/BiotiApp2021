package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ConCasas extends AppCompatActivity {

    private String nameM;
    ArrayList<String> names;
    TextView tname;
    Button casalisa, casacons;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_casas);

        tname = (TextView)findViewById(R.id.textViewName2);
        casalisa = (Button)findViewById(R.id.casalisa);
        casacons = (Button)findViewById(R.id.casacons);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);


    }

    public void Casalisa(View view){
        Intent intent = new Intent(this,ConCasa.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }

    public void CasaCons(View view){
        Intent intent = new Intent(this,CasaCons.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }


}