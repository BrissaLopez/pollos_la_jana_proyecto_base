package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearMes_act extends AppCompatActivity {
    public Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_mes_act);
    }

    public void crearDia(View v){

        i = new Intent(this, CrearIngresoDiario_act.class);
        startActivity(i);
    }
}