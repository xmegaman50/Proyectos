package com.boxstudio.AgregarDatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //se declaran componentes java
    EditText txtNombre, txtSigno, txtNacimiento, txtDatos;
    Button btnAgregar, btnLimpiar,btnlimpiardatos;

    //tipo de dato seguido de nombre de variable
    //int numeros enteros
    //double numeros punto decimal
    //String texto
    //boolean 0 1
    int nacimiento, edad;
    String nombre, signo, datos;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se enlaca los componentes java con los xml
        //nombre java un codigo  medio raro y nombre xml

        txtNombre = findViewById(R.id.txtNombre);
        txtSigno = findViewById(R.id.txtSigno);
        txtNacimiento = findViewById(R.id.txtNacimiento);
        txtDatos = findViewById(R.id.txtDatos);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnlimpiardatos = findViewById(R.id.btnlimpiardatos);

        //A practicamentecada componentese le pueden hacer por lo menos  dos acciones obtener y asignar datos


        //agregamos el evento del boton


        btnlimpiardatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDatos.setText("");
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // este es el cidogo que se va a ejecutar cuando se corra el evento

                //obtenemos los datos
                nombre = txtNombre.getText().toString();
                signo = txtSigno.getText().toString();
                nacimiento = Integer.parseInt(txtNacimiento.getText().toString());

                edad = 2018 - nacimiento;
                datos = datos + nombre + " - " + signo + " / " + nacimiento + "\n";
                txtDatos.setText(datos);

                String mayor;

                //si tiene mas de 18 años es mayor de edad
                //si no es menor de edad

                if (edad >= 18)

                {

                    mayor = "es mayor de edad";
                } else {
                    mayor = "No es mayor de edad";
                }

                //mostrar mensaje emergente temporal
                Toast mensaje = Toast.makeText(getApplicationContext(), mayor, Toast.LENGTH_SHORT);
                mensaje.show();
                limpiar();


            }
        });//Evento del boton


    }//oncreate

    public void limpiar()


    {

        txtNombre.setText("");
        txtNacimiento.setText("");
        txtSigno.setText("");
        txtNombre.requestFocus();

    }
}//class
