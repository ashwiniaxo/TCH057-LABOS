package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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



        // Si on appuie sur le bouton appeler
        if(v == appeler){
            if(!strNumeroTelephone.isBlank()){
                // Concaténation avec tel
                String completNumero ="tel:"+strNumeroTelephone;
                Uri u  = Uri.parse(completNumero);

                Intent intent21 = new Intent(Intent.ACTION_CALL,u);
                startActivity(intent21);
       }
//        else if () { faire un toast
//
//            }

        }
        // Si on appuie sur le bouton revenir en arriere
        else if(v == revenirArriere1){
            finish();
        }
    }
}









