package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.AdminSQLiteOpenHelper;

public class CrearIngresoDiario_act extends AppCompatActivity {

    private Spinner agno, mes, dia;
    private EditText inicioCaja, finCaja, detalles, identificador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ingreso_diario_act);

        agno = (Spinner)findViewById(R.id.spin1);
        mes = (Spinner)findViewById(R.id.spin2);
        dia = (Spinner)findViewById(R.id.spin3);
        inicioCaja = (EditText)findViewById(R.id.et_dia1);
        finCaja = (EditText)findViewById(R.id.et_dia2);
        detalles = (EditText)findViewById(R.id.et_dia4);
        identificador = (EditText)findViewById(R.id.et_dia3);

        ArrayList<String> listadoAgno = (ArrayList<String>)getIntent().getSerializableExtra("listadoAgno");
        ArrayList<String> listadoMes = (ArrayList<String>)getIntent().getSerializableExtra("listadoMes");
        ArrayList<String> listadoDia = (ArrayList<String>)getIntent().getSerializableExtra("listadoDia");

        ArrayAdapter<String> adaptaAgno = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listadoAgno);
        agno.setAdapter(adaptaAgno);
        ArrayAdapter<String> adaptaMes = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listadoMes);
        mes.setAdapter(adaptaMes);
        ArrayAdapter<String> adaptaDia = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listadoDia);
        dia.setAdapter(adaptaDia);

    }

    public void crearDiaDeTrabajo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "databasePollosLaJana", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobreescritura de mi base de datos

        if(!inicioCaja.getText().toString().isEmpty() || !finCaja.getText().toString().isEmpty() || !detalles.getText().toString().isEmpty() || !identificador.getText().toString().isEmpty() ){

            //añade un día de trabajo
            ContentValues registro = new ContentValues();
            registro.put("identificador", identificador.getText().toString());
            registro.put("agno", agno.getSelectedItem().toString());
            registro.put("mes", mes.getSelectedItem().toString());
            registro.put("dia", dia.getSelectedItem().toString());
            registro.put("inicioCaja", inicioCaja.getText().toString());
            registro.put("finCaja", finCaja.getText().toString());
            registro.put("observaciones", detalles.getText().toString());

            bd.insert("diaDeTrabajo", null, registro);
            bd.close();

            Toast.makeText(this, "Se ha registrado correctamente.", Toast.LENGTH_LONG).show();

        }else{

            Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_LONG).show();
        }
    }

    public void editarDiaDeTrabajo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "databasePollosLaJana", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //permito la sobreescritura de mi base de datos
        ContentValues cont = new ContentValues();

        String codigo = identificador.getText().toString();

        cont.put("identificador",identificador.getText().toString());
        cont.put("agno", agno.getSelectedItem().toString());
        cont.put("mes", mes.getSelectedItem().toString());
        cont.put("dia", dia.getSelectedItem().toString());
        cont.put("inicioCaja", inicioCaja.getText().toString());
        cont.put("finCaja", finCaja.getText().toString());
        cont.put("observaciones", detalles.getText().toString());

        if(!codigo.isEmpty()){
            bd.update("diaDeTrabajo", cont, "identificador="+codigo, null);

            Toast.makeText(this, "Se ha actualizado los datos del día de trabajo.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Debe ingresar un código fecha válido.", Toast.LENGTH_LONG).show();
        }

    }


}