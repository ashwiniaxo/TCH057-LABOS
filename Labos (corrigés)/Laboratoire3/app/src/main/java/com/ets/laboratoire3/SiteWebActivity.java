package com.ets.laboratoire3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SiteWebActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTrouverSite, btnRetour;
    EditText edTxtSiteWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_web);

        btnTrouverSite = findViewById(R.id.btnAdresseWeb_id);
        btnTrouverSite.setOnClickListener(this);

        btnRetour = findViewById(R.id.btnRetour_id);
        btnRetour.setOnClickListener(this);

        edTxtSiteWeb = findViewById(R.id.editTextAdresseWeb_id);
    }

    @Override
    public void onClick(View v) {
        if(v == btnTrouverSite) {
            String strSiteWeb = edTxtSiteWeb.getText().toString();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strSiteWeb));
            startActivity(browserIntent);
        }
        else if( v == btnRetour){
            finish();
        }
    }
}