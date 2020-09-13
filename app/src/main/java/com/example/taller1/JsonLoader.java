package com.example.taller1;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public  class JsonLoader {

    private AssetManager mngr;

    public JsonLoader()
    {
    }

    public void setContext(Context myContext)
    {
        mngr = myContext.getAssets();
    }

    public String loadJSONPaisFromAsset()
    {
        String json = null;
        try{
            InputStream is = mngr.open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch ( IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ArrayList<String> getPaisStringArray(){
        ArrayList<String> paises = new ArrayList<>();
        try{
            JSONObject json= new JSONObject(loadJSONPaisFromAsset());
            JSONArray paisesJsonArray= json.getJSONArray("paises");
            for(int i=0; i<paisesJsonArray.length(); i++)
            {
                JSONObject jsonObject= paisesJsonArray.getJSONObject(i);
                paises.add(jsonObject.getString("nombre_pais"));
            }
        }
        catch (JSONException jsonex)
        {
            jsonex.printStackTrace();
            return null;
        }
        return paises;
    }

    public  Pais getPais(String nombrePais)
    {
        Pais pais = null;
        try{
        JSONObject json= new JSONObject(loadJSONPaisFromAsset());
        JSONArray paisesJsonArray= json.getJSONArray("paises");
        for(int i=0; i<paisesJsonArray.length(); i++)
        {
            JSONObject jsonObject= paisesJsonArray.getJSONObject(i);
            if(jsonObject.getString("nombre_pais").equals(nombrePais))
            {
                String capital = jsonObject.getString("capital");
                String numHabitantes = jsonObject.getString("habitantes");
                String sigla = jsonObject.getString("sigla");
                String nombreInt = jsonObject.getString("nombre_pais_int");
                pais = new Pais(nombrePais,capital,numHabitantes,nombreInt,sigla);
            }
        }
        }
        catch (JSONException jsonex)
        {
            jsonex.printStackTrace();
            return null;
        }
        return pais;
    }

}
