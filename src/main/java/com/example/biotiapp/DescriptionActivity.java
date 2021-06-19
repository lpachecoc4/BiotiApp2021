package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView titleDescriptionTextView;
    TextView scaleDescriptionTextView;
    ImageView imageDescriptionView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListElement element = (ListElement) getIntent().getSerializableExtra("ListElement");
        titleDescriptionTextView = findViewById(R.id.textViewDA);
        imageDescriptionView = findViewById(R.id.imageViewDA);
        scaleDescriptionTextView = findViewById(R.id.textViewSDA);

        titleDescriptionTextView.setText(element.getName());
        scaleDescriptionTextView.setText("El índice BMWP es de "+element.getScale());
        imageDescriptionView.setImageResource(element.getImagePos());

    }
}