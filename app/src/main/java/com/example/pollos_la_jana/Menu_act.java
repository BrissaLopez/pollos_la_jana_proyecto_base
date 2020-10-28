package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private Intent i;

    private ViewFlipper vf;
    private int[] images = {R.drawable.polloprimerplano, R.drawable.papasfritas, R.drawable.chuleta, R.drawable.polloconpapas};

    private ArrayList<String> agno ;
    private ArrayList<String> mes ;
    private ArrayList<String> dia ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);


        //iterar la función del slider
        for(int i = 0; i< images.length; i++){
            flip_image(images[i]); //recibo mi arreglo de imagenes
        }


        agno = new ArrayList<String>();
        mes = new ArrayList<String>();
        dia = new ArrayList<String>();
        anadeDatos();
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

        i = new Intent(this, CrearIngresoDiario_act.class);
        i.putExtra("listadoAgno", agno);
        i.putExtra("listadoMes", mes);
        i.putExtra("listadoDia", dia);
        startActivity(i);
    }

    public void Balance(View v){

        i = new Intent(this, Balance_act.class);
        startActivity(i);
    }

    public void anadeDatos(){
        agno.add("2020");
        agno.add("2021");
        agno.add("2022");
        agno.add("2023");
        agno.add("2024");
        mes.add("Enero");
        mes.add("Febrero");
        mes.add("Marzo");
        mes.add("Abril");
        mes.add("Mayo");
        mes.add("Junio");
        mes.add("Julio");
        mes.add("Agosto");
        mes.add("Septiembre");
        mes.add("Octubre");
        mes.add("Noviembre");
        mes.add("Diciembre");
        dia.add("1");
        dia.add("2");
        dia.add("3");
        dia.add("4");
        dia.add("5");
        dia.add("6");
        dia.add("7");
        dia.add("8");
        dia.add("9");
        dia.add("10");
        dia.add("11");
        dia.add("12");
        dia.add("13");
        dia.add("14");
        dia.add("15");
        dia.add("16");
        dia.add("17");
        dia.add("18");
        dia.add("19");
        dia.add("20");
        dia.add("21");
        dia.add("22");
        dia.add("23");
        dia.add("24");
        dia.add("25");
        dia.add("26");
        dia.add("27");
        dia.add("28");
        dia.add("29");
        dia.add("30");
        dia.add("31");

    }

























}