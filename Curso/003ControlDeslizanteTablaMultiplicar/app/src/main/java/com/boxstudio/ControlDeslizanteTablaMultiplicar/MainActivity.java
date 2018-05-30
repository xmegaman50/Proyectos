package com.boxstudio.ControlDeslizanteTablaMultiplicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar skbValor;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skbValor= findViewById(R.id.skbValor);
        txtResultado=findViewById(R.id.txtResultado);

        skbValor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int num=skbValor.getProgress();
                txtResultado.setText("Resultado:");
                for(int a=0;a<=10;a++){
                    txtResultado.setText(txtResultado.getText()+"\n" +
                            num+ "x" +a+ "=" + (a*num));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
