package com.example.labonote1_naim_himrane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin, btnQuitter;
    EditText editTextUserName, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin_id);
        btnLogin.setOnClickListener(this);

        btnQuitter = findViewById(R.id.btnQuit_id);
        btnQuitter.setOnClickListener(this);

        editTextUserName = findViewById(R.id.editTextNomUtilisateur_id);
        editTextPassword = findViewById(R.id.editTextTextPassword_id);
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin) {
            if(!btnLogin.getText().toString().isEmpty() &&
            !editTextPassword.getText().toString().isEmpty()) {
                Intent intention = new Intent(this, DataActivity.class);
                intention.putExtra("nom", editTextUserName.getText().toString());
                startActivity(intention);
            }
        }
        else if (view == btnQuitter)
        {
            this.finish();
        }
    }
}