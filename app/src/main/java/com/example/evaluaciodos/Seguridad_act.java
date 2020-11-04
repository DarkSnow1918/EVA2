package com.example.evaluaciodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class Seguridad_act extends AppCompatActivity {

    private TextView texto;
    private EditText edit;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        texto = (TextView) findViewById(R.id.TvMostrar);
        edit = (EditText) findViewById(R.id.EtContra);
        btn = (Button) findViewById(R.id.BtnEncript);


    }
    //Metodo para generar una key o llave
    private SecretKeySpec generateKey(String password)throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // Firma para verificar la integridad
        byte[] key = password.getBytes("UTF-8");
        key = md.digest(key);
        SecretKeySpec secretKey = new SecretKeySpec(key,"AES");
        return secretKey;
    }
    //MEtodo para encriptar bajo el algoritmo AES
    public String Encriptar(String datos, String password)throws Exception{
        if(!edit.getText().toString().isEmpty())
        {
            //HAgo el encriptado de datos
            SecretKeySpec secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");//Obtengo el algoritmo AES
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);//Encripto bajo el CIPHER


            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);
            return datosEncriptadosString;
        }
        else
        {
            //Notificación en el dispositivo
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_LONG);
            return null;
        }

    }

    public void Encriptar(View view) {
        try{
            String mensaje = Encriptar(edit.getText().toString(), texto.getText().toString());
            texto.setText(mensaje);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}