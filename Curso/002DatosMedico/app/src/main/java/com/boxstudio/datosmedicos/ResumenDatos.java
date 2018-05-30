package com.boxstudio.datosmedicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResumenDatos extends AppCompatActivity {
    TextView txtNombre,txtPeso,txtAltura,txtSexo,txtResumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_datos);

        txtNombre = (TextView) findViewById(R.id.txtNombre);


        //Obtener datos del intent
        //Creaemos una variable del tipo intent para obtenet los datos que fueron enviados de la pantalla anterior

        Intent intentDatos = getIntent();

        txtNombre.setText(intentDatos.getStringExtra("nombre"));



    }
}

