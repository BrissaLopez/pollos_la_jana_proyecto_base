package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Menu_act extends AppCompatActivity {

    private Intent i;

    private ViewFlipper vf;
    private int[] images = {R.drawable.polloprimerplano, R.drawable.papasfritas, R.drawable.chuleta, R.drawable.polloconpapas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);


        //iterar la función del slider
        for(int i = 0; i< images.length; i++){
            flip_image(images[i]); //recibo mi arreglo de imagenes
        }
    }

    //configuración del slider
    public void flip_image(int i){

        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view); //añadimos las imagenes al ViewFlipper
        vf.setFlipInterval(10000); //su desplazamiento en mili segundos
        vf.setAutoStart(true); //iniciar de forma automática

        //sentido del slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Avanzado(View v){

        i = new Intent(this, Avanzado_act.class);
        startActivity(i);
    }

    public void CrearIngreso(View v){

        i = new Intent(this, CrearMes_act.class);
        startActivity(i);
    }
























}