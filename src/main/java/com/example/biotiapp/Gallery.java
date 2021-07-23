package com.example.biotiapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.EventLogTags;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Gallery extends AppCompatActivity {

    List<ListElement> elements;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        init();

    }

    public ListElement createItem(String name){
        DB = new DBHelper(this);
        String tscale = DB.getScale(name);
        int scale = Integer.parseInt(tscale);
        String tpos = DB.getPos(name);
        return new ListElement(name,scale,tpos);
    }


    public void init(){
        //DB = new DBHelper(this);
        elements = new ArrayList<>();
        elements.add(new ListElement("Aeshnidae",this));
        ListElement element1 = createItem("Baetidae");
        elements.add(element1);

        //elements.add(new ListElement("Aeshnidae", 6, R.drawable.aeshnidaem));
        //elements.add(new ListElement("Baetidae", 4, R.drawable.baetidae));
        elements.add(new ListElement("Blepharoceridae", 10, R.drawable.blepharoceridae));
        elements.add(new ListElement("Calamoceratidae", 10, R.drawable.calamoceridae));
        elements.add(new ListElement("Ceratopogonidae", 4, R.drawable.ceratopogonidae));
        elements.add(new ListElement("Chironomidae", 2, R.drawable.chironomidae));
        elements.add(new ListElement("Coenagrionidae", 6, R.drawable.coenagrionidae));
        elements.add(new ListElement("Corydalidae", 6, R.drawable.corydalidae));
        elements.add(new ListElement("Culicidae", 2, R.drawable.culicidae));
        elements.add(new ListElement("Dolichopodidae", 4, R.drawable.dolichopodidae));
        elements.add(new ListElement("Dystiscidae", 3, R.drawable.dytiscidae));
        elements.add(new ListElement("Elmidae", 5, R.drawable.elmidae));
        elements.add(new ListElement("Elmidae Larvae", 5, R.drawable.elmidae_larvae));
        elements.add(new ListElement("Empididae", 8, R.drawable.empididaem));
        elements.add(new ListElement("Ephydridae", 8, R.drawable.ephydridaem));
        elements.add(new ListElement("Eprilodactylidae", 5, R.drawable.eprilodactylidaem));
        elements.add(new ListElement("Gyrinidae", 3, R.drawable.gyrinidae));
        elements.add(new ListElement("Helicopsychidae", 10, R.drawable.helicopsychidae));
        elements.add(new ListElement("Hidrophilidae", 3, R.drawable.hidrophilidae));
        elements.add(new ListElement("Hidropsychidae", 5, R.drawable.hidropsychidae));
        elements.add(new ListElement("Hirudinea", 5, R.drawable.hirudineam));
        elements.add(new ListElement("Hyalellidae", 6, R.drawable.hyalellidaem));
        elements.add(new ListElement("Hydracarina", 4, R.drawable.hydracarinam));
        elements.add(new ListElement("Hydrobiosidae", 8, R.drawable.hydrobiosidae));
        elements.add(new ListElement("Hydroptilidae", 6, R.drawable.hydroptilidae));
        elements.add(new ListElement("Leptoceridae", 8, R.drawable.leptoceridae));
        elements.add(new ListElement("Leptohyphidea", 7, R.drawable.leptohyphideam));
        elements.add(new ListElement("Leptophlebiidae", 10, R.drawable.leptophlebiidae));
        elements.add(new ListElement("Lestidae", 8, R.drawable.lestidaem));
        elements.add(new ListElement("Libellulidae", 6, R.drawable.libellulidaem));
        elements.add(new ListElement("Lymnaeidae", 3, R.drawable.lymnaeidaem));
        elements.add(new ListElement("Muscidae", 2, R.drawable.muscidae));
        elements.add(new ListElement("Nematoda", 0, R.drawable.nematodam));
        elements.add(new ListElement("Odontoceridae", 10, R.drawable.odontoceridae));
        elements.add(new ListElement("Oligochaeta", 1, R.drawable.oligochaetam));
        elements.add(new ListElement("Ostrachoda", 3, R.drawable.ostracodam));
        elements.add(new ListElement("Perlidae", 10, R.drawable.perlidae));
        elements.add(new ListElement("Philopotamidae", 8, R.drawable.philopotamidae));
        elements.add(new ListElement("Physidae", 3, R.drawable.physidaem));
        elements.add(new ListElement("Planaridae", 5, R.drawable.planaridae));
        elements.add(new ListElement("Planorbidae", 3, R.drawable.planorbidaem));
        elements.add(new ListElement("Psephenidae", 5, R.drawable.psephenidae));
        elements.add(new ListElement("Psychodidae", 3, R.drawable.psychodidae));
        elements.add(new ListElement("Scirtidae", 5, R.drawable.scirtidae));
        elements.add(new ListElement("Sialidea", 6, R.drawable.sialidaem));
        elements.add(new ListElement("Simuliidae", 5, R.drawable.simuliidae));
        elements.add(new ListElement("Sphaeriidae", 3, R.drawable.sphaeriidaem));
        elements.add(new ListElement("Stratiomidae", 4, R.drawable.stratiomidae));
        elements.add(new ListElement("Syrphidae", 1, R.drawable.syrphidaem));
        elements.add(new ListElement("Tabanidae", 4, R.drawable.tabanidae));
        elements.add(new ListElement("Thiaridae", 3, R.drawable.thiaridaem));
        elements.add(new ListElement("Tipulidae", 5, R.drawable.tipulidae));
        elements.add(new ListElement("Xiphocentronidae", 8, R.drawable.xiphocentronidaem));

        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    public void moveToDescription(ListElement item){
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListElement",item);
        startActivity(intent);
    }


}