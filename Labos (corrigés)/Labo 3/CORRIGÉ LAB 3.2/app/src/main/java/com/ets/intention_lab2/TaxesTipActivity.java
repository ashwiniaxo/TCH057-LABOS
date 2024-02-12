package com.ets.intention_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaxesTipActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextTips;
    TextView textViewResultat;
    double montantAvecTaxes = 0;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxes_tip);

        btnOk = findViewById(R.id.btnOk_id);
        btnOk.setOnClickListener(this); // ajouter le bouton au écouteur pour le click
        // Récupérer ici le prix et la quantité provenant
        // de MainActivity via une intention en utilisant les get..Extra
        Intent intention = getIntent();
        String strPrix = intention.getStringExtra("prix");
        String strQte = intention.getStringExtra("quantité");

        double prix = Double.valueOf(strPrix); // convertir de string à double
        int qte = Integer.valueOf(strQte); // convertir de string à int

        // Calculer le prix avec les taxes
        montantAvecTaxes = prix*qte*(1+Taxes.TPS+Taxes.TVQ);

        // Convertir au string et ajouter le "$" avant l'affichage
        String strMontantAvecTaxes = String.valueOf(montantAvecTaxes) + " " + "$";

        textViewResultat = findViewById(R.id.textViewMontantTaxesResultat_id);
        textViewResultat.setText(strMontantAvecTaxes);
    }

    @Override
    public void onClick(View v) {

        // Récuperer le montant du tips
        editTextTips = findViewById(R.id.editTextTips_id);
        String strMontantAvecTaxesEtTips = editTextTips.getText().toString();
        if(  !strMontantAvecTaxesEtTips.isBlank()) {
            // N'oubliez pas de convertir le string "strMontantAvecTaxesEtTips"  en double
            double montantAvecTaxesEtTips = montantAvecTaxes + Double.valueOf(strMontantAvecTaxesEtTips);

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