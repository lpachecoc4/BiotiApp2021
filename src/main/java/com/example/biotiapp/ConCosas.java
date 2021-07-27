package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConCosas extends AppCompatActivity {

    List<ListElement> elements;
    List<String> cosas;
    TextView tname;
    ArrayList<String> names;
    private String nameM;
    String[] measureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_cosas);

        init();

        tname = (TextView)findViewById(R.id.textViewName8);

        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");

        tname.setText(nameM);

    }

    public void init(){
        cosas = new ArrayList<>();
        elements = new ArrayList<>();

        cosas.add("Blepharoceridae");
        cosas.add("Ceratopogonidae");
        cosas.add("Chironomidae");
        cosas.add("Culicidae");
        cosas.add("Dolichopodidae");
        cosas.add("Empididae");
        cosas.add("Ephydridae");
        cosas.add("Muscidae");
        cosas.add("Psychodidae");
        cosas.add("Simuliidae");
        cosas.add("Stratiomidae");
        cosas.add("Syrphidae");
        cosas.add("Tabanidae");
        cosas.add("Tipulidae");

        for (int i = 0; i < cosas.size(); i++){
            elements.add(new ListElement(cosas.get(i),this));
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