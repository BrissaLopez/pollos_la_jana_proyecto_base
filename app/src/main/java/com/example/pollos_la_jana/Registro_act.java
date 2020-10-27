package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Registro_act extends AppCompatActivity {

    private EditText id, nombre, apellido, usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_act);

        id = (EditText)findViewById(R.id.et_reg1);
        nombre = (EditText)findViewById(R.id.et_reg2);
        apellido = (EditText)findViewById(R.id.et_reg3);
        usuario = (EditText)findViewById(R.id.et_reg4);
        contrasena = (EditText)findViewById(R.id.et_reg5);
    }

    public void anadirColaborador(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "databasePollosLaJana", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobreescritura de mi base de datos

        if(!id.getText().toString().isEmpty() || !nombre.getText().toString().isEmpty() || !apellido.getText().toString().isEmpty() || !usuario.getText().toString().isEmpty() || !contrasena.getText().toString().isEmpty()){

            //añade un colaborador o usuario de la app
            ContentValues registro = new ContentValues();
            registro.put("id", id.getText().toString());
            registro.put("nombre", nombre.getText().toString());
            registro.put("apellido", apellido.getText().toString());
            registro.put("usuario", usuario.getText().toString());
            registro.put("contrasena", contrasena.getText().toString());

            bd.insert("colaboradores", null, registro);
            bd.close();

            Toast.makeText(this, "Se ha registrado correctamente.", Toast.LENGTH_LONG).show();

        }else{

            Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_LONG).show();
        }
    }
}