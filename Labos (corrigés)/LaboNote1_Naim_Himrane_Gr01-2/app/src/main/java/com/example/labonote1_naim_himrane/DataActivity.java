package com.example.labonote1_naim_himrane;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {
    static int RESULT_US = 10;
    static int RESULT_EURO = 102;
    public static final int CODE_ACTIVITE_DATA = 100;
    TextView txtViewBonjourX;
    EditText edTextMontantCanToUs;
    TextView txtViewResUs;
    Button btnChercherTaux, vtnConvertir, btnRetour;
    float tauxUs, tauxEuro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Intent intention = getIntent();
        String strNomUtilisateur = intention.getStringExtra("nom");
        txtViewBonjourX = findViewById(R.id.textViewBonjourX_id);
        txtViewBonjourX.setText("Bonjour " + strNomUtilisateur);

        edTextMontantCanToUs = findViewById(R.id.editTextCanUs_id);

        txtViewResUs = findViewById(R.id.textViewResUs_id);

        btnChercherTaux = findViewById(R.id.btnChercherTaux_id);
        btnChercherTaux.setOnClickListener(this);

        vtnConvertir = findViewById(R.id.btnCovertir_id);
        vtnConvertir.setOnClickListener(this);

        btnRetour = findViewById(R.id.btnRetour_id);
        btnRetour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) { //, vtnConvertir, ;
        if(view == btnChercherTaux) {
            Intent intention = new Intent(this, CalculTauxActivity.class);
            startActivityForResult(intention, CODE_ACTIVITE_DATA);
        } else if(view == vtnConvertir) {
            try {
                float resUs = Float.parseFloat(edTextMontantCanToUs.getText().toString()) * tauxUs;
                txtViewResUs.setText(String.valueOf(resUs) + " $ US");

            } catch (Exception exp) {
            }
        } else if( view == btnRetour) {
            this.finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CODE_ACTIVITE_DATA:
                if(data != null) {
                    tauxUs = data.getFloatExtra("TAUXUS", 1);
                } break;
            default:break;
        }
    }
}