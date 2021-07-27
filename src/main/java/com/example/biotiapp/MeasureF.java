package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MeasureF extends AppCompatActivity {

    List<ListElement> elements;
    ArrayList<ListElement2> mediciones;
    ArrayList<String> names;
    TextView tname;
    String nameM;
    Boolean isAdded;
    DBHelper DB;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_f);

        tname = (TextView)findViewById(R.id.textViewName3);

        init();
        loadMediciones();

        isAdded = (Boolean) getIntent().getSerializableExtra("isAdded");
        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        if(isAdded){
            names = (ArrayList<String>) getIntent().getSerializableExtra("names");
            for(int i = 0; i < names.size(); i++){
                elements.add(new ListElement(names.get(i),this));
            }
        }

        tname.setText(nameM);
        //elements.add(element);

    }

    public ListElement createItem(String name){
        DB = new DBHelper(this);
        String tscale = DB.getScale(name);
        int scale = Integer.parseInt(tscale);
        String tpos = DB.getPos(name);
        return new ListElement(name,scale,tpos);
    }

    public void init(){
        elements = new ArrayList<>();
        names = new ArrayList<>();

        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                //deleteFromMeasure(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void deleteFromMeasure(ListElement item){
        elements.remove(item);
    }

    public void Agregar(View view){
        Intent intent = new Intent(this, Measure1.class);
        intent.putExtra("measureData",measureData);
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }

    public void Medir(View view){

        mediciones.add(new ListElement2(names,measureData,this));
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mediciones);
        editor.putString("task list", json);
        editor.apply();
        Intent intent = new Intent(this, Mediciones.class);
        startActivity(intent);
    }

    public void loadMediciones(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ListElement2>>() {}.getType();
        mediciones = gson.fromJson(json, type);

        if (mediciones == null) {
            mediciones = new ArrayList<>();
        }


    }

}