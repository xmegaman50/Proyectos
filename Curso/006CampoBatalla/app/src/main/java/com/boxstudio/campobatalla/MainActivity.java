package com.boxstudio.campobatalla;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//OnCreate es el primero codigo que se ejecuta cuando se crea la activity
public class MainActivity extends AppCompatActivity {
    //declaramos un objeto de la clase personaje
    Personaje goku, yamcha;
    EditText txtInfop1;
    EditText txtInfop2;
    Button btnpocionp1, btnpocionp2, btnatacarp1, btnatacarp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Asignamos memria a objetos
        //Iniiclializacion
        //Instancia.se instancia los objetos

        goku = new Personaje();
        yamcha = new Personaje();

        txtInfop1 = findViewById(R.id.txtInfop1);
        txtInfop2 = findViewById(R.id.txtInfop2);
        btnpocionp1 = findViewById(R.id.btnpocionp1);
        btnpocionp2 = findViewById(R.id.btnpocionp2);
        btnatacarp1 = findViewById(R.id.btnatacarp1);
        btnatacarp2 = findViewById(R.id.btnatacarp2);


        //Asignamos las carecterisitcas de variables del objeto

        goku.nombre = "Goku";
        goku.ataque = 100;
        goku.defensa = 80;
        goku.vida = 500;
        goku.monedas = 1000;

        yamcha.nombre = "Yamcha";
        yamcha.ataque = 150;
        yamcha.defensa = 60;
        yamcha.vida = 300;
        yamcha.monedas = 1000;

        String datosp1;
        datosp1 = "Nombre : " + goku.nombre + "\n Ataque : " + goku.ataque + "\n Defensa : " + goku.defensa + "\n Vida : " + goku.vida + "\n Monedas : " + goku.monedas + "";

        txtInfop1.setText(datosp1);

        String datosp2;
        datosp2 = "Nombre : " + yamcha.nombre + "\n Ataque : " + yamcha.ataque + "\n Defensa : " + yamcha.defensa + "\n Vida : " + yamcha.vida + "\n Monedas: " + yamcha.monedas + "";

        txtInfop2.setText(datosp2);

        // se ceran los eventos de clic de los botones
        //Con ayuda del editor de texto
        //Nombre del boton enter desues dentro del los parentesis new View enter

        btnatacarp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inicioo codigo boton
                //invoccion metodo
                goku.atacar(yamcha);


                String datosp2;

                datosp2 = "Nombre : " + yamcha.nombre + "\n Ataque : " + yamcha.ataque + "\n Defensa : " + yamcha.defensa + "\n Vida : " + yamcha.vida + "\n Monedas: " + yamcha.monedas + "";
                txtInfop2.setText(datosp2);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Goku Ataca", Toast.LENGTH_SHORT);

                toast1.show();
                //desues de haber aumentado la vida del personaje
                //tenemos que mostrar los satos en el edit text
                //fin de codigo boton

            }
        });


        btnatacarp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inicioo codigo boton
                //invoccion metodo
                yamcha.atacar(goku);


                String datosp1;
                datosp1 = "Nombre : " + goku.nombre + "\n Ataque : " + goku.ataque + "\n Defensa : " + goku.defensa + "\n Vida : " + goku.vida + "\n Monedas : " + goku.monedas + "";

                txtInfop1.setText(datosp1);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Yamcha Ataco", Toast.LENGTH_SHORT);

                toast1.show();
                //desues de haber aumentado la vida del personaje
                //tenemos que mostrar los satos en el edit text
                //fin de codigo boton

            }
        });


        btnpocionp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inicioo codigo boton
                //invoccion metodo
                goku.tomarPocion(500);

                String datosp1;
                datosp1 = "Nombre : " + goku.nombre + "\n Ataque : " + goku.ataque + "\n Defensa : " + goku.defensa + "\n Vida : " + goku.vida + "\n Monedas : " + goku.monedas + "";

                txtInfop1.setText(datosp1);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Goku toma pocion", Toast.LENGTH_SHORT);

                toast1.show();
                //desues de haber aumentado la vida del personaje
                //tenemos que mostrar los satos en el edit text
                //fin de codigo boton

            }
        });


        btnpocionp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inicioo codigo boton
                //invoccion metodo
                yamcha.tomarPocion(500);


                String datosp2;
                datosp2 = "Nombre : " + yamcha.nombre + "\n Ataque : " + yamcha.ataque + "\n Defensa : " + yamcha.defensa + "\n Vida : " + yamcha.vida + "\n Monedas: " + yamcha.monedas + "";

                txtInfop2.setText(datosp2);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Yamcha toma pocion", Toast.LENGTH_SHORT);

                toast1.show();

                //desues de haber aumentado la vida del personaje
                //tenemos que mostrar los satos en el edit text
                //fin de codigo boton


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
