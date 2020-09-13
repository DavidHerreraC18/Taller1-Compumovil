package com.example.taller1;

public class Pais {

    private String nombrePais;

    private String capital;

    private String numHabitantes;

    private String nombreInt;

    private String sigla;

    public Pais(String nombrePais, String capital, String numHabitantes, String nombreInt, String sigla) {
        this.nombrePais = nombrePais;
        this.capital = capital;
        this.numHabitantes = numHabitantes;
        this.nombreInt = nombreInt;
        this.sigla = sigla;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCapital() {
        return capital;
    }

    public String getNumHabitantes() {
        return numHabitantes;
    }

    public String getNombreInt() {
        return nombreInt;
    }

    public String getSigla() {
        return sigla;
    }
}
