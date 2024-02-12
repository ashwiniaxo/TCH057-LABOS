package com.example.labo22;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CODE_ACTIVITE_1=1;
    Button taxesTips;
    EditText prix, quantite;
    TextView resultat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taxesTips = findViewById(R.id.btnTaxesTips_id);
        taxesTips.setOnClickListener(this);

        prix=findViewById(R.id.editTextTextPrix_id);
        quantite=findViewById(R.id.editTextTextQuantite_id);

    }

    @Override
    public void onClick(View v) {
        Intent intention = new Intent(this, TaxesTipsActivity.class);
        intention.putExtra("prix",prix.getText().toString());
        intention.putExtra("quantite", quantite.getText().toString());
        startActivityForResult(intention, CODE_ACTIVITE_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case CODE_ACTIVITE_1:   // C'est l'activité 2 qui s'est terminé
                if(resultCode==RESULT_OK){
                    resultat=findViewById(R.id.textViewResultat_id);
                    if(data!=null){
                        double totalAvecTips=data.getDoubleExtra("montantavectips",0);
                        resultat.setText(String.valueOf(totalAvecTips));
                    }
                    else{
                        Toast.makeText(this, "Pas de données valides.", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}