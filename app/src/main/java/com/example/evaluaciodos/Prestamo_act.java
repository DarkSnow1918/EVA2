package com.example.evaluaciodos;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Creditos;

public class Prestamo_act extends AppCompatActivity {
    private Spinner spinCliente, spinCredito;
    private TextView text;
    Clientes clientes = new Clientes();
    Creditos creditos = new Creditos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);


        spinCliente = (Spinner)findViewById(R.id.SpClientes);
        spinCredito = (Spinner)findViewById(R.id.SpCreditos);
        text = (TextView)findViewById(R.id.TvResultado);

        ArrayList<String> listaCli = (ArrayList<String>)getIntent().getSerializableExtra("listaCliente");
        listaCli.add(clientes.getAxel());
        listaCli.add(clientes.getRoxana());
        listaCli.add(clientes.getBetzabe());
        listaCli.add(clientes.getMatias());

        ArrayList<String> listaCre = (ArrayList<String>)getIntent().getSerializableExtra("listaCredito");
        listaCre.add(creditos.getCreHipo());
        listaCre.add(creditos.getCreAuto());


        ArrayAdapter<String> adpCli = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaCli);
        ArrayAdapter<String> adpCre = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaCre);
        spinCliente.setAdapter(adpCli);
        spinCredito.setAdapter(adpCre);




    }


    public void CalcularPrestamo(View view) {

        String cliente = spinCliente.getSelectedItem().toString();
        String credito = spinCredito.getSelectedItem().toString();

        if (cliente.equals(clientes.getAxel()) && credito.equals(creditos.getCreHipo())) {
            int prestamo = clientes.getSalAxel() + creditos.getValHipo();
            text.setText("Su saldo final es: " + prestamo);

        }

        if (cliente.equals(clientes.getAxel()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = clientes.getSalAxel() + creditos.getValAuto();
            text.setText("Su saldo final es: " + prestamo);

        }

        if (cliente.equals(clientes.getRoxana()) && credito.equals(creditos.getCreHipo())) {
            int prestamo = clientes.getSalRox() + creditos.getValHipo();
            text.setText("Su saldo final: " + prestamo);

        }

        if (cliente.equals(clientes.getRoxana()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = clientes.getSalRox() + creditos.getValAuto();
            text.setText("Su saldo final es: " + prestamo);

        }

        if (cliente.equals(clientes.getBetzabe()) && credito.equals(creditos.getCreHipo())) {
            int prestamo = clientes.getSalBet() + creditos.getValHipo();
            text.setText("Su saldo final: " + prestamo);

        }

        if (cliente.equals(clientes.getBetzabe()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = clientes.getSalBet() + creditos.getValAuto();
            text.setText("Su saldo final: " + prestamo);

        }

        if (cliente.equals(clientes.getMatias()) && credito.equals(creditos.getCreHipo())) {
            int prestamo = clientes.getSalMat() + creditos.getValHipo();
            text.setText("Su saldo final es: " + prestamo);

        }

        if (cliente.equals(clientes.getMatias()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = clientes.getSalMat() + creditos.getValAuto();
            text.setText("Su saldo final es: " + prestamo);
        }

    }

    public void CalcularDeudas(View view) {

        String cliente = spinCliente.getSelectedItem().toString();
        String credito = spinCredito.getSelectedItem().toString();


        if (cliente.equals(clientes.getAxel()) && credito.equals(creditos.getCreHipo())) {
            float deuda = (clientes.getSalAxel() + creditos.getValHipo()) / creditos.getCuotaHipo();
            text.setText("Su deuda es de: " + deuda+" en 12 cuotas");

        }

        if (cliente.equals(clientes.getAxel()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = (clientes.getSalAxel() + creditos.getValAuto()) / creditos.getCuotaAuto();
            text.setText("Su deuda es de: " + prestamo+" en 8 cuotas");

        }

        if (cliente.equals(clientes.getRoxana()) && credito.equals(creditos.getCreHipo())) {
            int prestamo = (clientes.getSalRox() + creditos.getValHipo()) / creditos.getCuotaHipo();
            text.setText("Su deuda es de: " + prestamo+" en 12 cuotas");

        }

        if (cliente.equals(clientes.getRoxana()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = (clientes.getSalRox() + creditos.getValAuto()) / creditos.getCuotaAuto();
            text.setText("Su deuda es de: " + prestamo+" en 8 cuotas");

        }

        if (cliente.equals(clientes.getBetzabe()) && credito.equals(creditos.getCreHipo())) {
            int prestamo = (clientes.getSalBet() + creditos.getValHipo()) / creditos.getCuotaHipo();
            text.setText("Su deuda es de: " + prestamo +" en 12 cuotas");

        }

        if (cliente.equals(clientes.getMatias()) && credito.equals(creditos.getCreAuto())) {
            int prestamo = (clientes.getSalMat() + creditos.getValAuto())/creditos.getCuotaAuto();
            text.setText("Su deuda es de: " + prestamo+" en 8 cuotas");

        }
    }
}