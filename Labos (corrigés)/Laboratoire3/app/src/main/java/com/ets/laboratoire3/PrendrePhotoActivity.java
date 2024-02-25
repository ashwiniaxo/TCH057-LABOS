package com.ets.laboratoire3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PrendrePhotoActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgPhoto;
    Button btnPhotoPicker, btnRetour;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prendre_photo);

        btnRetour = findViewById(R.id.btnRetour_id);
        btnRetour.setOnClickListener(this);

        btnPhotoPicker = findViewById(R.id.btnPhoto_id);
        btnPhotoPicker.setOnClickListener(this);

        imgPhoto = findViewById(R.id.imageViewPhoto_id);
    }

    @Override
    public void onClick(View v) {

        if(v == btnPhotoPicker) {
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE);
        }
        else if(v == btnRetour) {
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == REQUEST_IMAGE_CAPTURE) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(photo);
        }
    }
}