package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Déclaration des boutons
    private Button saisirNumero;
    private Button prendrePhoto;
    private Button rechercheInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saisirNumero = findViewById(R.id.btnNumero_id);
        saisirNumero.setOnClickListener(this);

        prendrePhoto = findViewById(R.id.btnPhoto_id);
        prendrePhoto.setOnClickListener(this);

        rechercheInternet = findViewById(R.id.btnRecherche_id);
        rechercheInternet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == saisirNumero){
            Intent intention1 = new Intent(this, Activity2.class);
            startActivity(intention1);
        }
        else if(v == prendrePhoto){
            Intent intention2 = new Intent(Intent.ACTION_CAMERA_BUTTON);
            startActivity(intention2);
        }
        else if(v==rechercheInternet){
            Intent intention3 = new Intent(Intent.ACTION_SEARCH);
            startActivity(intention3);
        }
    }
}