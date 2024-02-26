package com.example.labonote1_naim_himrane;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculTauxActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int PERMISSION_INTERNET = 200;
    static int RESULT_US = 10;

    EditText edTxtTauxUs;
    Button btnRetour, btnVerifierInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_taux);

        edTxtTauxUs = findViewById(R.id.editTextTauxUs_id);

        btnVerifierInternet = findViewById(R.id.btnAdresseWeb_id);
        btnVerifierInternet.setOnClickListener(this);

        btnRetour = findViewById(R.id.btnRetour_id);
        btnRetour.setOnClickListener(this);

        btnRetour.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        if(view == btnVerifierInternet)
        {
            btnRetour.setEnabled(true);
            String[] permissionsAAccorder = {Manifest.permission.INTERNET};

            int resInternet = ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.INTERNET);


            if (resInternet == PackageManager.PERMISSION_GRANTED  )
            {
                //Permissions déjà accordées.
                Toast.makeText(this, "Permission déjà accordée", Toast.LENGTH_SHORT).show();
            } else {
                // Permission pas encore accordée.
                //Toast.makeText(this, "Permission pas encore accordée", Toast.LENGTH_SHORT).show();
                requestPermissions(permissionsAAccorder, PERMISSION_INTERNET);
            }
        }
        else
            if (view == btnRetour) {
            try {
                float resUs = 1, resEuro = 1;
                Intent intentResultat = new Intent();
                String strResultatUs = edTxtTauxUs.getText().toString();
                try {
                    resUs = Float.parseFloat(strResultatUs);
                }
                catch (Exception exp) {
                }
                intentResultat.putExtra("TAUXUS", resUs);

                this.setResult(RESULT_US, intentResultat);
                this.finish();
            }
            catch (Exception exp) {
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_INTERNET:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission déjà accordée", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission non accordée", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }
}