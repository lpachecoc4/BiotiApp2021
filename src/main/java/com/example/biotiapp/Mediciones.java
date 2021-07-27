package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Mediciones extends AppCompatActivity {

    List<ListElement> elements;
    ArrayList<ListElement2> mediciones;
    ArrayList<String> names;
    ImageButton home, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediciones);

        home = (ImageButton)findViewById(R.id.imageButton);
        delete = (ImageButton)findViewById(R.id.imageButton2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
                sharedPreferences.edit().remove("task list").commit();
                goHome();
            }
        });

        init();

    }

    public void init(){
        //DB = new DBHelper(this);
        elements = new ArrayList<>();
        names = new ArrayList<>();

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ListElement2>>() {}.getType();
        mediciones = gson.fromJson(json, type);

        if (mediciones == null) {
            mediciones = new ArrayList<>();
        }


        ListAdapter2 listAdapter = new ListAdapter2(mediciones, this, new ListAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement2 item) {
                moveToVM(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    public void moveToVM(ListElement2 item){
        String[] s = new String[3];
        s[0] = item.getNameM();
        s[1] = item.getDateM();
        s[2] = item.getTimeM();
        ArrayList<String> tempNames = new ArrayList<>();
        tempNames = item.getNames();
        Intent intent = new Intent(this, VerMedicion.class);
        intent.putExtra("measureData",s);
        intent.putExtra("names", tempNames);
        startActivity(intent);
    }

    public void goHome(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}