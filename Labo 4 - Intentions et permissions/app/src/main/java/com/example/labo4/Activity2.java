package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    // Déclarations
    EditText editTextPhoneNumber;
    Button appeler;
    Button revenirArriere1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        appeler = findViewById(R.id.btnAppeler_id);
        appeler.setOnClickListener(this);

        revenirArriere1 = findViewById(R.id.btnRevenir1_id);
        revenirArriere1.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        editTextPhoneNumber = findViewById(R.id.editTxtPhoneNum_id);
        String strNumeroTelephone = editTextPhoneNumber.getText().toString();
        if(!strNumeroTelephone.isBlank()){
            // Concaténation avec tel
            String completNumero =
        }

    }
}









