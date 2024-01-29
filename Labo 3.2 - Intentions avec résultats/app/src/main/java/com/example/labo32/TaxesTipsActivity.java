package com.example.labo32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaxesTipsActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextTips;
    TextView textViewResultat;
    double montantAvecTaxes = 1;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxes_tips);

        btnOk = findViewById(R.id.btnConfirmer_id);
        btnOk.setOnClickListener(this); // ajouter le bouton au écouteur pour le click
        // Récupérer ici le prix et la quantité provenant
        // de MainActivity via une intention en utilisant les get..Extra
        Intent intention = getIntent();
        String strPrix = intention.getStringExtra("prix");
        String strQte = intention.getStringExtra("quantité");

        double prix = Double.valueOf(strPrix);
        int quantite = Integer.valueOf(strQte);

        // Calculer le prix total avec les taxes
        montantAvecTaxes = prix*quantite*(1+0.15);

        // Convertir le résultat en string et rajouter le $ pour l'affichage
        String resultat = String.valueOf(montantAvecTaxes) + " " + "$";

        textViewResultat = findViewById(R.id.coutAvecTaxes_id);
        textViewResultat.setText(resultat);
    }

    @Override
    public void onClick(View v) {
        // Récupérer le montant du tips
        editTextTips = findViewById(R.id.montantTips_id);
        String  strMontantTips = editTextTips.getText().toString();

        if(  !strMontantTips.isBlank()) {
            // N'oubliez pas de convertir le string "strMontantAvecTaxesEtTips"  en double
            double montantAvecTaxesEtTips = montantAvecTaxes + Double.valueOf(strMontantTips);

            // Envoyer le montantAvecTaxesEtTips à MainActivity via une intention
            Intent intention = new Intent();
            intention.putExtra("montantavectips", montantAvecTaxesEtTips);
            setResult(RESULT_OK);
            finish(); // Terminer cette activity (TaxesTipActivity)
            // et retourner à MainActivity
        }
        else // ici si on rentre rien dans le Tips et pour eviter que votre application plante, faites un else et afficher un message
        {
            Toast.makeText(this, "Vous devez saisir une valeur dans le Tips", Toast.LENGTH_SHORT).show();
        }
    }
}