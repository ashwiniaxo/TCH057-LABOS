package com.example.labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Activity1 extends AppCompatActivity implements View.OnClickListener{

    // oa for open activity
    Button oa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        oa1 = findViewById(R.id.btnSuivantEcran1_id);    // Récupérer le bouton déclarer dans le XML file
        oa1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        Intent intention = new Intent(this,Activity2.class);

        // ouvrir une activité avec une intention
        startActivity(intention);
    }

}