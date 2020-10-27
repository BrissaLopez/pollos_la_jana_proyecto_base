package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearIngreso_act extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ingreso_act);
    }

    public void CrearIngresoDiario(View v){

        i = new Intent(this, CrearIngresoDiario_act.class);
        startActivity(i);
    }

    public void CrearIngresoMes(View v){

        i = new Intent(this, CrearMes_act.class);
        startActivity(i);
    }

}