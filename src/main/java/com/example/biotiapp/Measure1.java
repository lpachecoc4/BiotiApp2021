package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Measure1 extends AppCompatActivity {

    private String nameM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure1);

        nameM = (String) getIntent().getSerializableExtra("nameM") ;

        TextView tname;
        tname = (TextView)findViewById(R.id.textViewName);
        tname.setText(nameM);
    }

    public void ConCasa(View view){
        Intent concasa = new Intent(this,ConCasa.class);
        concasa.putExtra("nameM",nameM);
        startActivity(concasa);

    }

    //public void SinCasa(View view){
    //    Intent sincasa = new Intent(this,ConCasa.class);
    //    startActivity(concasa);
    //}

}