package com.boxstudio.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstdatos = findViewById(R.id.lstdatos);
        String[] values = new String[]{"Cafe Tacuba", "Inspector", "Gran Silencio", "Cafres", "Molotov", "Pericos"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        lstdatos.setAdapter(adaptador);

        lstdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item = position;
                String itemValue = (String) lstdatos.getItemAtPosition(item);
                Toast.makeText(getApplicationContext(), "Posicion" + item + "Valor" + itemValue, Toast.LENGTH_LONG);

                Intent intent = new Intent(MainActivity.this, DetalllesConcierto.class);

                intent.putExtra("Artista", itemValue);
                startActivity(intent);
            }
        });
        ;

    }
}
