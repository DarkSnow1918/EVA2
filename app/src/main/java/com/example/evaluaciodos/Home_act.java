package com.example.evaluaciodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;


public class Home_act extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] images={R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);
        vf = (ViewFlipper)findViewById(R.id.slider);

        for (int i=0; i<images.length; i++)
        {
            Flip_image(images[i]);
        }
    }

    public void Flip_image(int i)
    {
        //Vamos a dar la configuración al slider

        ImageView v = new ImageView(this);
        v.setBackgroundResource(i);

        vf.addView(v);                  //Añadimos las imagenes al flipper
        vf.setFlipInterval(2000);       //Su desplazamiento será de 2seg
        vf.setAutoStart(true);          //Inniciar de forma automatica

        //Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left); //Empieza de la izquierda
        vf.setInAnimation(this, android.R.anim.slide_out_right);//Termina en la derecha


    }
    public void Seguridad(View view)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);

    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Cliente(View view)
    {
        Intent i = new Intent(this, Cliente_act.class);
        startActivity(i);
    }

    public void Prestamos(View view)
    {
        ArrayList<String> Credito = new ArrayList<String>();
        ArrayList<String> Cliente = new ArrayList<String>();

        Intent i = new Intent(this, Prestamo_act.class);
        i.putExtra("listaCliente", Cliente);
        i.putExtra("listaCredito", Credito);
        startActivity(i);
    }
}