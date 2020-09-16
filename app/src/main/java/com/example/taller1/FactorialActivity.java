package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FactorialActivity extends AppCompatActivity {

    TextView campoFactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        Intent intent = getIntent();
        int numero = Integer.parseInt(intent.getStringExtra("NUMERO_FACTORIAL"));
        campoFactorial = findViewById(R.id.texto_factorial);
        String multiplicacion = getStringMultiplicacion(numero);
        long resultado = getResultado(numero);
        campoFactorial.setText("Multiplicación: "+ multiplicacion + "\n" + "Resultado: " + resultado);
        //Toast.makeText(getBaseContext(),numero,Toast.LENGTH_SHORT).show();
    }

    private long getResultado(int numero) {
        long resultado = 1;
        while(numero != 0){
            resultado = resultado * numero;
            numero--;
        }
        return resultado;
    }

    private String getStringMultiplicacion(int numero) {
        String multiplicacion = "";
        for(int i = 0; i<numero; i++){
            if(i == 0){
                int dato = i+1;
                multiplicacion = multiplicacion + dato;
            }else{
                int dato = i+1;
                multiplicacion = multiplicacion + "*" + dato;
            }
        }
        return multiplicacion;
    }
}