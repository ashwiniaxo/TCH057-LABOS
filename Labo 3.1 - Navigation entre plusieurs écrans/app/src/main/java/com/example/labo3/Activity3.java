package com.example.labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {

    Button oa31;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        oa31 = findViewById(R.id.btnPrecedantEcran3_id);    // Récupérer le bouton déclarer dans le XML file
        oa31.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent intention31 = new Intent(this,Activity2.class);

        // ouvrir une activité avec une intention
        startActivity(intention31);
    }
}