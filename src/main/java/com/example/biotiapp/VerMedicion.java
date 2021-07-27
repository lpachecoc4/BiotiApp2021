package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VerMedicion extends AppCompatActivity {

    TextView nameMTV, dateMTV, timeMTV, resultMTV, resultadoMTV;
    ArrayList<String> names;
    String[] measureData;
    List<ListElement> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_medicion);

        init();
        measureData = (String[]) getIntent().getSerializableExtra("measureData");
        String nameM = measureData[0];
        names = (ArrayList<String>) getIntent().getSerializableExtra("names");
        for(int i = 0; i < names.size(); i++){
            elements.add(new ListElement(names.get(i),this));
        }

        nameMTV = (TextView)findViewById(R.id.TVnameM);
        dateMTV = (TextView)findViewById(R.id.textViewDateVM);
        timeMTV = (TextView)findViewById(R.id.textViewTimeVM);
        resultMTV = (TextView)findViewById(R.id.textViewResultVM);
        resultadoMTV = (TextView)findViewById(R.id.textViewResultadoVM);

        ListElement2 X = new ListElement2(names, measureData, this);
        nameMTV.setText(measureData[0]);
        dateMTV.setText(measureData[1]);
        timeMTV.setText(measureData[2]);
        resultadoMTV.setText(X.getResultado());
        resultMTV.setText(X.getResult());

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

}