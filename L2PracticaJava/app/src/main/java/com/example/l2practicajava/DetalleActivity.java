package com.example.l2practicajava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final SuperH objSuper = (SuperH) extras.getSerializable("KEYOBJSUPER");

            if (objSuper != null) {
                final TextView lblNombreHeroe = findViewById(R.id.lblNombreHeroe);
                final ANImageView imgSuperHeroe = findViewById(R.id.imgSuperHeroe);

                lblNombreHeroe.setText(objSuper.getNombre());
                imgSuperHeroe.setImageUrl(objSuper.getFoto());
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
