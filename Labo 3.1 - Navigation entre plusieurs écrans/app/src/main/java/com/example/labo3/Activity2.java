package com.example.labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button oa21;
    Button oa22;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        oa21 = findViewById(R.id.btnPrecedantEcran2_id);    // Récupérer le bouton déclarer dans le XML file
        oa21.setOnClickListener(this);
        oa22= findViewById(R.id.btnSuivantEcran2_id);
        oa22.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPrecedantEcran2_id) {
            Intent intention21 = new Intent(this, Activity1.class);
            startActivity(intention21);
        } else if (v.getId() == R.id.btnSuivantEcran2_id) {
            Intent intention22 = new Intent(this, Activity3.class);
            startActivity(intention22);

        /*
        Intent intention21 = new Intent(this, Activity1.class);

        // ouvrir une activité avec une intention
        startActivity(intention21);

        Intent intention22 = new Intent(this, Activity3.class);

        // ouvrir une activité avec une intention
        startActivity(intention22);
        */
        }
    }
}