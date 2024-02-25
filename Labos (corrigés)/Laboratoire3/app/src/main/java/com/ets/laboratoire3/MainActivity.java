package com.ets.laboratoire3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnComposer, btnCamera, btnSiteWeb;
    int resPhone, resInternet, resCamera;
    final int PERMISSION_APPEL_INTERNET_CAMERA = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComposer = findViewById(R.id.btnComposerTel_id);
        btnComposer.setOnClickListener(this);

        btnCamera = findViewById(R.id.btnPrendrePhoto_id);
        btnCamera.setOnClickListener(this);

        btnSiteWeb = findViewById(R.id.btnConsulterWeb_id);
        btnSiteWeb.setOnClickListener(this);

        // je vérifie les permissions au démarrage de l'application
        String[] permissionsAAccorder = {android.Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA, Manifest.permission.INTERNET};

        resPhone = ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.CALL_PHONE);
        resInternet = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA);
        resCamera = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.INTERNET);

        if (resPhone == PackageManager.PERMISSION_GRANTED &&
                resInternet == PackageManager.PERMISSION_GRANTED &&
                resCamera == PackageManager.PERMISSION_GRANTED )
        {
            //Permissions déjà accordées.
            //Toast.makeText(this, "Permissions déjà accordée", Toast.LENGTH_SHORT).show();
        } else {
            // Permission pas encore accordée.
            //Toast.makeText(this, "Permission pas encore accordée", Toast.LENGTH_SHORT).show();
            requestPermissions(permissionsAAccorder, PERMISSION_APPEL_INTERNET_CAMERA);
        }
    }

    @Override
    public void onClick(View v) {

       if(v == btnComposer) {
           Intent intent = new Intent(this, AppelTelephoneActivity.class);
           startActivity(intent);
       } else if (v == btnCamera) {
           Intent intent = new Intent(this, PrendrePhotoActivity.class);
           startActivity(intent);
       } else if (v == btnSiteWeb) {
           Intent browserIntent = new Intent(this, SiteWebActivity.class);
           startActivity(browserIntent);
       }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_APPEL_INTERNET_CAMERA:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(this, "Permissions déjà accordées", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(this, "Au moins une des 3 Permissions non accordée.s", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }
}