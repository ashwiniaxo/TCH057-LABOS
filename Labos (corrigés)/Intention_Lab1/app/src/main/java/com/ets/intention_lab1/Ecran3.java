package com.ets.intention_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ets.intention_lab1.R;

public class Ecran3 extends AppCompatActivity implements View.OnClickListener{

    Button btnPrecedent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran3);

        btnPrecedent = findViewById(R.id.btnPrecedentId); // on pointe sur le bouton Suivant déjà crée dans le XML
        btnPrecedent.setOnClickListener(this); // on enregistre le bouton Precedent comme écouteur
    }

    @Override
    public void onClick(View v) {
        // Je n'a pas besoin de créer une intention pour revenir à l'écran précédent
        finish(); // terminer l'écran 3 et revenir automatiquement à l'écran 2
    }
}