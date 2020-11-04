package com.example.evaluaciodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        video = (VideoView)findViewById(R.id.VvInfo);
        String ruta = "android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        //Controles del video

        MediaController media = new MediaController(this);
        video.setMediaController(media);


    }

    public void mapa(View view)
    {
        Intent i = new Intent(this,Maps_act.class);
        startActivity(i);
    }
}