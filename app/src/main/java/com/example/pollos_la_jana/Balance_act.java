package com.example.pollos_la_jana;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Balance_act extends AppCompatActivity {

    private EditText codigo;
    private TextView ver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_act);

        codigo = (EditText)findViewById(R.id.et_ver1);
        ver= (TextView)findViewById(R.id.tv_ver1);
    }


    public void mostrarDiaDeTrabajo(View v){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "databasePollosLaJana", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String identifica = codigo.getText().toString();

        if(!identifica.isEmpty()){

            //Cursor: clase que me permite recorrer filas
            Cursor fila = bd.rawQuery("SELECT identificador, agno, mes, dia, inicioCaja, finCaja, observaciones FROM diaDeTrabajo WHERE identificador="+ identifica, null);

            if(fila.moveToFirst()){
                String fCaja = fila.getString(5);
                String iCaja = fila.getString(4);
                int intFCaja = Integer.parseInt(fCaja);
                int intICaja = Integer.parseInt(iCaja);
                int ganancia = intFCaja - intICaja;

                ver.setText("Código identificador: " + fila.getString(0)+ "\n"+
                        "Fecha: "+ fila.getString(3)+ "-"+fila.getString(3)+"-"+fila.getString(1)+"\n"+
                        "Inicio de caja: $" + fila.getString(4)+"\n"+
                        "Fin de caja: $" + fila.getString(5)+"\n"+
                        "Ganancia del día: $" + ganancia+"\n"+
                        "Ingresos-Egresos-Observaciones: "+fila.getString(6));
            }else{
                Toast.makeText(this, "No hay día de trabajo identificado con el código fecha ingresado.", Toast.LENGTH_LONG).show();
            }

        }else{

            Toast.makeText(this, "Debe ingresar el código fecha del día de trabajo.", Toast.LENGTH_LONG).show();

        }

    }



    public void eliminarDiaDeTrabajo(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "databasePollosLaJana", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String identifica = codigo.getText().toString();

        bd.delete("diaDeTrabajo", "identificador="+ identifica, null);
        bd.close();

        Toast.makeText(this, "Se ha eliminado el día de trabajo con el código " + identifica, Toast.LENGTH_LONG).show();
        ver.setText("Detalles");
    }




}