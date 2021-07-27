package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Lisos extends AppCompatActivity {

    List<ListElement> elements;
    List<String> lisos;
    TextView tname;
    ArrayList<String> names;
    private String nameM;
    String[] measureData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisos);
        init();

        tname = (TextView)findViewById(R.id.textViewName7);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);
    }

    public void init(){
        lisos = new ArrayList<>();
        elements = new ArrayList<>();

        lisos.add("Hirudinea");
        lisos.add("Nematoda");
        lisos.add("Oligochaeta");
        lisos.add("Planaridae");

        for (int i = 0; i < lisos.size(); i++){
            elements.add(new ListElement(lisos.get(i),this));
        }

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