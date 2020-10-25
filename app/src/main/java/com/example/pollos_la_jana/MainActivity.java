package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb;
    private Button btn;

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb= (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);

        pb.setVisibility(View.INVISIBLE); //la progress bar se hace invisible
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                new Task().execute(); //ejecuto mi tarea asíncrona.
            }
        });
    }


   class Task extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute(){

            pb.setVisibility(View.VISIBLE);
        }

       @Override
       protected java.lang.String doInBackground(java.lang.String... strings) {

            for (int i = 1; i<= 10; i++){

                try {
                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
           return null;
       }

       @Override
       protected void onPostExecute(String s) { //finaliza mi tarea asíncrona
            pb.setVisibility(View.INVISIBLE);
           i= new Intent(getBaseContext(), Menu_act.class);
           startActivity(i);
       }
   }



    public void registro(View v){

        i = new Intent(this, Registro_act.class);
        startActivity(i);
    }


    //tarea pesada
    /*
    public void Hilo(View v){

        for(int i = 1; i <=10; i++){

            try {

                Thread.sleep(2000);

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }*/
}