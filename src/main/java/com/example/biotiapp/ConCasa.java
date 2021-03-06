package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConCasa extends AppCompatActivity {

    List<ListElement> elements;
    DBHelper DB;
    List<String> conchas;
    TextView tname;
    ArrayList<String> names;
    private String nameM;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_casa);

        init();

        tname = (TextView)findViewById(R.id.textViewName3);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);

    }

    public ListElement createItem(String name){
        DB = new DBHelper(this);
        String tscale = DB.getScale(name);
        String tpos = DB.getPos(name);
        return new ListElement(name,tscale,tpos);
    }


    public void init(){
        conchas = new ArrayList<>();
        elements = new ArrayList<>();

        conchas.add("Lymnaeidae");
        conchas.add("Ostrachoda");
        conchas.add("Physidae");
        conchas.add("Planorbidae");
        conchas.add("Sphaeriidae");
        conchas.add("Thiaridae");

        for (int i = 0; i < conchas.size(); i++){
            elements.add(new ListElement(conchas.get(i),this));
        }
        /*
        elements.add(new ListElement("Lymnaeidae", 3, R.drawable.lymnaeidaem));
        elements.add(new ListElement("Ostrachoda", 3, R.drawable.ostracodam));
        elements.add(new ListElement("Physidae", 3, R.drawable.physidaem));
        elements.add(new ListElement("Planorbidae", 3, R.drawable.planorbidaem));
        elements.add(new ListElement("Sphaeriidae", 3, R.drawable.sphaeriidaem));
        elements.add(new ListElement("Thiaridae", 3, R.drawable.thiaridaem));*/

        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToMeasureF(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    public void moveToMeasureF(ListElement item){
        Intent intent = new Intent(this, MeasureF.class);
        intent.putExtra("measureData",measureData);
        intent.putExtra("isAdded",true);
        names.add(item.getName());
        intent.putStringArrayListExtra("names",names);
        startActivity(intent);
    }


}