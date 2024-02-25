package com.ets.laboratoire3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppelTelephoneActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAppeler, btnRetour;
    EditText edTxtNumPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel_telephone);

        btnAppeler = findViewById(R.id.btnAdresseWeb_id);
        btnAppeler.setOnClickListener(this);

        btnRetour = findViewById(R.id.btnRetour_id);
        btnRetour.setOnClickListener(this);

        edTxtNumPhone = findViewById(R.id.editTextNumPhone_id);
    }

    @Override
    public void onClick(View v) {

        if( v == btnAppeler) {
            String strPhone = edTxtNumPhone.getText().toString();
            Uri u = Uri.parse("tel:" + strPhone);
            Intent intent = new Intent(Intent.ACTION_CALL, u);
            startActivity(intent);
        }
        else if( v == btnRetour) {
            finish();
        }
    }
}