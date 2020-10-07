package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Avanzado_act extends AppCompatActivity {
    private Intent i;
    private VideoView videoView;
    private String ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avanzado_act);


        videoView = (VideoView)findViewById(R.id.vd); //llamo al elemento VideoView


        //Asignar nuestro video mp4 al videoview a través de su ruta
        ruta = "android.resource://" + getPackageName() + "/" + R.raw.video; //obtenemos la ruta del video
        Uri uri = Uri.parse(ruta);

        videoView.setVideoURI(uri);



        //Controles del video.
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }

    public void maps(View v){
        i = new Intent(this, Maps_act.class);
        startActivity(i);
    }

    public void sobreNosotros(View v){
        i = new Intent(this, SobreNosotros_act.class);
        startActivity(i);
    }

    public void pagos(View v){
        i = new Intent(this, Pagos_act.class);
        startActivity(i);
    }
}