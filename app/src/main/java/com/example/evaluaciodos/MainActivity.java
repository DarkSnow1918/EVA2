package com.example.evaluaciodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText contra;
    private ProgressBar pb;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.EtNombre);
        contra = (EditText)findViewById(R.id.EtContra);
        pb = (ProgressBar)findViewById(R.id.ProBar);
        boton = (Button)findViewById(R.id.BtnLogin);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nombre.getText().toString().isEmpty() || !contra.getText().toString().isEmpty()){
                    if(nombre.getText().toString().equals("android") && contra.getText().toString().equals("123")||nombre.getText().toString().equals("ANDROID")){
                        new Task().execute();
                    }
                }
                else
                {
                    Toast.makeText(boton.getContext(),"No puede haber campos en blanco", Toast.LENGTH_SHORT).show();
                }

            }
        });

        pb.setVisibility(View.INVISIBLE);
    }

    class Task extends AsyncTask<String, Void, String>
    {
        //Configura el proceso inicial de mi tarea
        @Override
        protected void onPreExecute() {

            pb.setVisibility(View.VISIBLE);
        }

        //Emplea la tarea
        @Override
        protected String doInBackground(String... strings) {
            for (int i = 1; i<=10;i++)
            {

                try {
                    Thread.sleep(1000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }


            return null;
        }

        //Finaliza mi tarea asíncrona
        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);


        }
    }
}