package com.example.labo22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button taxesTips;
    EditText prix, quantite;


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
        intention.putExtra()

    }
}