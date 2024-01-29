package com.example.labo32;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // oa pour Open Activity
    Button btnTaxesTips;
    EditText editTextPrix, editTextQuantite;
    TextView textViewTaxesTips;
    private static final int CODE_ACTIVITE_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Les champs textes où l'utilisateru va rentrer les informations
        editTextPrix=findViewById(R.id.affichagePrix_id);
        editTextQuantite=findViewById(R.id.affichageQuantite_id);

        // Activation du bouton
        btnTaxesTips = findViewById(R.id.btnTaxesTips_id);
        btnTaxesTips.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Envoyer le prix et la quantité à TaxesTipActivity
        // en utilisant une intention avec les putExtra
        Intent intention = new Intent(this, TaxesTipsActivity.class);
        intention.putExtra("prix", editTextPrix.getText().toString());
        intention.putExtra("quantité", editTextQuantite.getText().toString());
        startActivityForResult(intention, CODE_ACTIVITE_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case CODE_ACTIVITE_1 : //c’est Activite2 qui s’est terminée.
                if (resultCode == RESULT_OK) {
                    // Récuperer le montant avec taxes et tips reçu dans l'intention data
                    textViewTaxesTips = findViewById(R.id.textCoutTotal_id);
                    // On reçoit un objet data de type Intent en paramètre,
                    // il faut toujours tester un objet avant de l<utiliser
                    if (data != null) {
                        double totalAvecTips = data.getDoubleExtra("montantavectips", 0);
                        textViewTaxesTips.setText(String.valueOf(totalAvecTips));
                    } else {
                        Toast.makeText(this, "Pas de données valides", Toast.LENGTH_LONG).show();
                    }
                } break;
        }
    }
}
