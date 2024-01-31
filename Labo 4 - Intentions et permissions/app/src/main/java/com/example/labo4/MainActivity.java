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
            Uri u = Uri.parse("tel:514899999");
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);

        }
    }
}