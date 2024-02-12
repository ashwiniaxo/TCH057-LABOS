package com.example.labo22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaxesTipsActivity extends AppCompatActivity implements View.OnClickListener {
    Button ok;
    TextView montantSansTips;
    EditText tips;
    double doublemontantSansTips=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxes_tips);

        ok=findViewById(R.id.btnOK_id);
        ok.setOnClickListener(this);
        montantSansTips=findViewById(R.id.textViewMontantSansTips_id);
        tips=findViewById(R.id.editTextTextTips_id);

        Intent intention=getIntent();
        String strPrix = intention.getStringExtra("prix");
        String strQuantite = intention.getStringExtra("quantite");

        double prix = Double.valueOf(strPrix);
        double quantite = Double.valueOf(strQuantite);

        doublemontantSansTips = prix*quantite;
        String strmontantSansTips = String.valueOf(doublemontantSansTips)+" "+"$";
        montantSansTips.setText(strmontantSansTips);
    }

    @Override
    public void onClick(View v) {
        // Récupérer le montant du tips
        String strTips = tips.getText().toString();
        if(!strTips.isEmpty()){
            double montantTotal = doublemontantSansTips + Double.valueOf(strTips);

            // Envoyer le montant total à main activity avec une intention
            Intent intention = new Intent();
            intention.putExtra("montantavectips", montantTotal);
            setResult(RESULT_OK, intention);
            finish();
        }
        else{
            Toast.makeText(this, "Vous devez saisir une valeur dans le tips", Toast.LENGTH_LONG).show();
        }

    }
}