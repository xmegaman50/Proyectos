package com.boxstudio.datosmedicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre;
    //Mediante Alt Enter se realiza la
    //importaciòn de bibliotecas necesarias para cada objeto
    Button btnAceptar; // Creamos una variable de tipo Button llamada btnAceptar


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //Hacemos referencia a
        //txtNombre que se encuentra en la vista con la variable txtNombre
        //findViewById es una funciòn de Java, que nos permite obtener
        //algun recurso, en este caso de la clase "R"
        //Asignamos a checkbox
        //un true para que este aparezca seleccionado por defecto
              btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombre.getText().toString();
                //el metodo .getText() nos permite obtener la informacion
                //que el usuario ingrese a ese campo de texto
                //la funciòn .toString() transforma la informaciòn
                //a una cadena para que pueda ser manipulada

                //Funcion que almacena las acciones que se
                //llevaran a cabo cuando el usuario de click
                //al button.
                Intent intent = new Intent(MainActivity.this, ResumenDatos.class);
                intent.putExtra("nombre", nombre);
                // la funciòn putExtra permite enviar un valor
                //de una Pantalla a otra y que este pueda ser
                //manipulado desde la otra pantalla
                //Posee dos parametros, el primero de ellos se refiere a
                //el identificador que este tendra en la otra pantalla,
                //el segundo refiere al valor que tendrà, al colocar una
                //variable como segundo parametro, enviamos su contenido
                //NO la variable como tal

                startActivity(intent);
            }
        });
    }
}
