package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FibonacciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
        List<String> numeros = fibonacci(5);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numeros);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        ImageButton fibonacciButton =findViewById(R.id.fibonacciButton);
        fibonacciButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Fibonacci";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    private ArrayList<String> fibonacci(int numero)
    {
        ArrayList <String> arreglo = new ArrayList<String>();
        arreglo.add("0");
        if (numero == 1)
        {
            return arreglo;
        }
        else if(numero == 2)
        {
            arreglo.add("1");
            return arreglo;
        }
        else{
            arreglo.add("1");
            int num1 = 0;
            int num2 = 1;
            int sum;
            int i = 2;
            do {
                sum = num1+num2;
                arreglo.add(""+sum);
                num1 = num2;
                num2 = sum;
                i++;
            } while (i < numero);
        }
        return arreglo;
    }
}