package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pisosC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pisos_c);


        notification notification = new notification();
        notification.notificar(this);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);
        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(pisosC.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosC.this, Edificios.class);
                startActivity(int2);
            }
        });

        Button btnPiso1C = (Button)findViewById(R.id.btnPiso1C);
        btnPiso1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosC.this, BanoC.class);
                startActivity(int2);
            }
        });

        Button btnPiso2C = (Button)findViewById(R.id.btnPiso2C);
        btnPiso2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosC.this, BanoC.class);
                startActivity(int2);
            }
        });

        Button btnPiso3C = (Button)findViewById(R.id.btnPiso3C);
        btnPiso3C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosC.this, BanoC.class);
                startActivity(int2);
            }
        });


    }
}
