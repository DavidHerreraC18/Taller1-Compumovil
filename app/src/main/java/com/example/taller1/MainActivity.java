package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements LifecycleObserver {
    Button botonFibonacci;
    EditText campoFibonacci;
    Button botonFactorial;
    Spinner spinnerFactorial;
    Button botonPais;
    Integer[] arregloFactorial;
    int cantidadFactorial = 0;
    int cantidadFibonacci = 0;
    Date fechaFactorial;
    Date fechaFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonFibonacci = findViewById(R.id.botonFibonacci);
        botonFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoFibonacci = findViewById(R.id.campoFibonacci);
                if(!(TextUtils.isEmpty(campoFibonacci.getText().toString()))){
                    Intent intent = new Intent(getBaseContext(),FibonacciActivity.class);
                    intent.putExtra("POSICIONES_FIBONACCI",campoFibonacci.getText().toString());
                    startActivity(intent);
                    cantidadFibonacci++;
                    fechaFibonacci = new Date();
                }else{
                    Toast.makeText(getBaseContext(),"Aun no ingresa una posicion",Toast.LENGTH_SHORT).show();
                }
            }
        });
        spinnerFactorial = findViewById(R.id.spinnerFactorial);
        initArreglo();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,arregloFactorial);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFactorial.setAdapter(adapter);
        botonFactorial = findViewById(R.id.botonFactorial);
        botonFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),FactorialActivity.class);
                intent.putExtra("NUMERO_FACTORIAL",spinnerFactorial.getSelectedItem().toString());
                startActivity(intent);
                cantidadFactorial++;
                fechaFactorial = new Date();
            }
        });
        botonPais = findViewById(R.id.botonPaises);
        botonPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),PaisesActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String aviso = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Boolean mostrar = false;
        if(fechaFactorial != null) {
            aviso = aviso + "Factorial: \n" + " Accesos: " + cantidadFactorial + "\n Ultima vez accedido: " + formatter.format(fechaFactorial) + "\n";
            mostrar= true;
        }
        if(fechaFibonacci != null) {
            aviso = aviso + "Fibonacci: \n" + " Accesos: " + cantidadFibonacci + "\n Ultima vez accedido: " + formatter.format(fechaFibonacci) + "\n";
            mostrar= true;
        }
        if (mostrar) {
            Toast.makeText(getBaseContext(), aviso, Toast.LENGTH_SHORT).show();
        }
    }

    private void initArreglo(){
        arregloFactorial =  new Integer[15];
        for(int i = 0; i<arregloFactorial.length;i++){
            arregloFactorial[i]= i+1;
        }
    }
}

