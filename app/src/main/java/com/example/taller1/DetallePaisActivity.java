package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DetallePaisActivity extends AppCompatActivity {
    JsonLoader jsonLoader = new JsonLoader();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);
        jsonLoader.setContext(this);
        Intent intent = getIntent();
        TextView nombrePais = findViewById(R.id.nombrePais);
        TextView nombreCapital = findViewById(R.id.nombreCap);
        TextView nombreInt = findViewById(R.id.nombreInt);
        TextView numHab = findViewById(R.id.numHab);
        TextView nombreSigla = findViewById(R.id.nombreSigla);
        ImageView iv = findViewById(R.id.imagePais);

        Pais pais = jsonLoader.getPais(intent.getStringExtra("NOMBRE_PAIS"));

        nombrePais.setText(pais.getNombrePais());
        nombreCapital.setText(pais.getCapital());
        nombreInt.setText(pais.getNombreInt());
        nombreSigla.setText(pais.getSigla());
        numHab.setText(pais.getNumHabitantes());
        try {
            InputStream is = this.getAssets().open(pais.getSigla()+".jpg");
            Drawable d = Drawable.createFromStream(is , "src");
            iv.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}