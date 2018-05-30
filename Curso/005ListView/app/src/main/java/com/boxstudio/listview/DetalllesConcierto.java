package com.boxstudio.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalllesConcierto extends AppCompatActivity {
    TextView txtArtista, txtLugar, txtCiudad;
    ImageView imgArtista;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallles_concierto);


        txtArtista = findViewById(R.id.txtArtista);
        txtLugar = findViewById(R.id.txtLugar);
        txtCiudad = findViewById(R.id.txtCiudad);

        imgArtista = findViewById(R.id.imgArtista);

        btnRegresar = findViewById(R.id.btnRegresar);

        String artista = getIntent().getStringExtra("Artista");

        switch (artista) {
            case "Cafe Tacuba":
                txtArtista.setText(artista);
                txtCiudad.setText("CDMX");
                txtLugar.setText("Arena Mexico");
                imgArtista.setImageResource(R.drawable.s1);
                break;

            case "Inspector":
                txtArtista.setText(artista);
                txtCiudad.setText("Monterrey");
                txtLugar.setText("Arena Leon");
                imgArtista.setImageResource(R.drawable.s2);
                break;

            case "Gran Silencio":
                txtArtista.setText(artista);
                txtCiudad.setText("Guadlaajara");
                txtLugar.setText("Cancha GDL");
                imgArtista.setImageResource(R.drawable.s3);
                break;

            case "Cafres":
                txtArtista.setText(artista);
                txtCiudad.setText("Guanajuato");
                txtLugar.setText("Momias teatro");
                imgArtista.setImageResource(R.drawable.s4);
                break;

            case "Molotov":
                txtArtista.setText(artista);
                txtCiudad.setText("Nayarit");
                txtLugar.setText("Arena Mexico");
                imgArtista.setImageResource(R.drawable.s5);
                break;

            case "Pericos":
                txtArtista.setText(artista);
                txtCiudad.setText("Jamaica");
                txtLugar.setText("Jerez");
                imgArtista.setImageResource(R.drawable.s6);
                break;

            default:
                txtArtista.setText("Sin registro");
                txtCiudad.setText("Sin registro");
                txtLugar.setText("Sin registro");
                imgArtista.setImageResource(R.drawable.s7);
                break;
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalllesConcierto.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}



