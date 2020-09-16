package com.example.taller1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PaisesActivity extends AppCompatActivity {
    JsonLoader jsonLoader = new JsonLoader();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        jsonLoader.setContext(this);
        List<String> listaPaises = jsonLoader.getPaisStringArray();
        if(listaPaises != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPaises);
            final ListView listView = (ListView) findViewById(R.id.listPaises);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(getBaseContext(), DetallePaisActivity.class);
                    String nombrePais = (String) listView.getItemAtPosition(position);
                    intent.putExtra("NOMBRE_PAIS", nombrePais);
                    startActivity(intent);
                }
            });
        }
    }
}