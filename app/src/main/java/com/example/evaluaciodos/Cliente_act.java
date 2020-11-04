package com.example.evaluaciodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Cliente_act extends AppCompatActivity {
    private EditText codee,name,salario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_act);
        codee = (EditText)findViewById(R.id.EtCode);
        name = (EditText)findViewById(R.id.EtName);
        salario = (EditText)findViewById(R.id.EtSalario);
    }



    public void GuardarCliente(View view)
    {
        AdminSQLiteOpenHelper sql = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = sql.getWritableDatabase();//permito la sobreescritura en mi base de datos

        if(!codee.getText().toString().isEmpty())
        {
            //Añade el insumo
            ContentValues registro = new ContentValues();

            registro.put("codigo",codee.getText().toString());
            registro.put("nombre",name.getText().toString());
            registro.put("salario",salario.getText().toString());


            db.insert("clientes",null,registro);
            db.close();

            Toast.makeText(this,"Se ha guardado un Cliente!",Toast.LENGTH_LONG).show();



        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código Cliente.", Toast.LENGTH_LONG).show();
        }
    }



    public void MostrarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = codee.getText().toString();
        if(!codigo.isEmpty())
        {
            Cursor fila = bd.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo = " +codigo,null);

            if(fila.moveToFirst())//Devuelve un resultado
            {
                name.setText(fila.getString(0));
                salario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this,"No hay clientes con el código asociado", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código del cliente", Toast.LENGTH_LONG).show();
        }


    }

    public void EliminarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codee.getText().toString();

        if (!codigo.isEmpty())
        {
            bd.delete("clientes","codigo="+codigo, null);
            Toast.makeText(this,"Has eliminado cliente",Toast.LENGTH_LONG).show();
            codee.setText("");
            name.setText("");
            salario.setText("");
        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código del cliente", Toast.LENGTH_LONG).show();
        }

    }

    public void UpdateCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codee.getText().toString();

        ContentValues cont = new ContentValues();
        cont.put("codigo",codee.getText().toString());
        cont.put("nombre",name.getText().toString());
        cont.put("salario",salario.getText().toString());


        if (!codigo.isEmpty())
        {
            bd.update("clientes", cont, "codigo="+codigo,null);

            Toast.makeText(this,"Se ha actualizado el campo", Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Debes ingresar el código del cliente", Toast.LENGTH_LONG).show();
        }

    }
}