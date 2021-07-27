package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ConPatas extends AppCompatActivity {



    private String nameM;
    ArrayList<String> names;
    TextView tname;
    Button comoaraña, comocamaron, ciempies, ojosgrandes, colas, uñascuerpo, cuernos, patasuñas;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_patas);

        tname = (TextView)findViewById(R.id.textViewName9);
        comoaraña = (Button)findViewById(R.id.araña);
        comocamaron = (Button)findViewById(R.id.camaron);
        ciempies = (Button)findViewById(R.id.ciempies);
        ojosgrandes = (Button)findViewById(R.id.ojosgrandes);
        colas = (Button)findViewById(R.id.colas);
        uñascuerpo = (Button)findViewById(R.id.uñascuerpo);
        patasuñas = (Button)findViewById(R.id.patasuñas);
        cuernos = (Button)findViewById(R.id.cuernos);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);

    }

    public void ComoAraña(View view){
        Intent i = new Intent(this,ComoArana.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void ComoCamaron(View view){
        Intent i = new Intent(this,ComoCamaron.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void Ciempies(View view){
        Intent i = new Intent(this,Ciempies.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void OjosGrandes(View view){
        Intent i = new Intent(this,OjosGrandes.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void Colas(View view){
        Intent i = new Intent(this,VariasColas.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void UnasCuerpo(View view){
        Intent i = new Intent(this,UnasCuerpo.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void Cuernos(View view){
        Intent i = new Intent(this,Cuernos.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }

    public void PatasUnas(View view){
        Intent i = new Intent(this,PatasUnas.class);
        i.putExtra("measureData",measureData);
        i.putStringArrayListExtra("names",names);
        startActivity(i);
    }



}