package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MeasureF extends AppCompatActivity {

    List<ListElement> elements;
    ListElement tempElement;
    List<String> names;
    TextView tname;
    String nameM;
    Boolean isAdded;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_f);

        tname = (TextView)findViewById(R.id.textViewName3);

        init();

        nameM = (String) getIntent().getSerializableExtra("nameM");
        isAdded = (Boolean) getIntent().getSerializableExtra("isAdded");
        if(isAdded){
            names.add((String) getIntent().getSerializableExtra("name"));
            for(int i = 0; i < names.size(); i++){
                elements.add(new ListElement(names.get(i),this));
            }
        }

        tname.setText(nameM);
        //elements.add(element);

    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putIntegerArrayList();
    }*/

    public ListElement createItem(String name){
        DB = new DBHelper(this);
        String tscale = DB.getScale(name);
        int scale = Integer.parseInt(tscale);
        String tpos = DB.getPos(name);
        return new ListElement(name,scale,tpos);
    }

    public void init(){
        elements = new ArrayList<>();
        //elements.add(new ListElement("Aeshnidae", 6, R.drawable.aeshnidaem));


        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                deleteFromMeasure(item);
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
        intent.putExtra("nameM",nameM);
        startActivity(intent);
    }

    public void Medir(View view){
        Intent intent = new Intent(this, Measure1.class);
        startActivity(intent);
    }

}