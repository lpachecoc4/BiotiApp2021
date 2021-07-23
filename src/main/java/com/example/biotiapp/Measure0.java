package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class Measure0 extends AppCompatActivity {

    private EditText etNameM;
    private EditText etDate;
    private EditText etTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure0);

        etNameM = (EditText)findViewById(R.id.editTextName);
        etDate = (EditText)findViewById(R.id.editTextDate);
        etTime = (EditText)findViewById(R.id.editTextTime);

        etDate.setText(null);
        etNameM.setText(null);
        etTime.setText(null);

    }


    public void Register(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String nameM = etNameM.getText().toString();
        String date = etDate.getText().toString();
        String time = etTime.getText().toString();


        if(!nameM.isEmpty() && !date.isEmpty() && !time.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("name", nameM);
            registro.put("date", date);
            registro.put("time", time);
            database.insert("medicion", null, registro);

            database.close();
            etDate.setText(null);
            etNameM.setText(null);
            etTime.setText(null);
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MeasureF.class);
            intent.putExtra("nameM",nameM);
            intent.putExtra("isAdded",false);
            //intent.putExtra("item",null);
            startActivity(intent);

        } else{

            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();

        }

    }




}