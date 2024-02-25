package com.ets.intention_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ets.intention_lab1.R;

public class Ecran1 extends AppCompatActivity implements View.OnClickListener{

    Button btnSuivant; // on déclare un attribut (variable membre) qui est le bouton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran1);

        btnSuivant = findViewById(R.id.btnSuivantId); // on pointe sur le bouton Suivant déjà crée dans le XML
        btnSuivant.setOnClickListener(this); // on enregistre le bouton Suivant comme écouteur
    }

    @Override
    public void onClick(View v) {
        // on cliquant sur le b
        // on crée une intention pour lancer l'écran 3
        Intent intention = new Intent(this, Ecran2.class);
        startActivity(intention);
    }
}