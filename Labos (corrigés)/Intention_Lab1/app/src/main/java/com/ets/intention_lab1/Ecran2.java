package com.ets.intention_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ets.intention_lab1.R;

public class Ecran2 extends AppCompatActivity implements View.OnClickListener {

    Button btnSuivant, btnPrecedent; // on déclare les 2 attributs (variables membres)
                                    // de type Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran2);

        btnSuivant = findViewById(R.id.btnSuivantId); // on pointe sur le bouton Suivant déjà crée dans le XML
        btnSuivant.setOnClickListener(this); // on enregistre le bouton Suivant comme écouteur

        btnPrecedent = findViewById(R.id.btnPrecedentId); // on pointe sur le bouton Precedent déjà crée dans le XML
        btnPrecedent.setOnClickListener(this); // on enregistre le bouton Precedent comme écouteur
    }

    @Override
    public void onClick(View v) {
        final int i = v.getId();

        if(v.getId() == R.id.btnSuivantId) // si je clique sur le bouton Suivant
        {
            // on crée une intention pour lancer l'écran 3
            Intent intention = new Intent(this, Ecran3.class);
            startActivity(intention);
        }
        else  if(v.getId() == R.id.btnPrecedentId) // si je clique sur le bouton Precedent
        {
            // Je n'a pas besoin de créer une intention pour revenir à l'écran précédent
            // on quitte seulement l'activité et on revient à l'activité 1 qui l'a appelé
            finish();
        }
    }
}