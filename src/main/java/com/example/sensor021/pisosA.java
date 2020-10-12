package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pisosA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pisos_a);

        notification notification = new notification();
        notification.notificar(this);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);
            emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(pisosA.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosA.this, Edificios.class);
                startActivity(int2);
            }
        });

        Button btnPiso1A = (Button)findViewById(R.id.btnPiso1A);
        btnPiso1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosA.this, banoA1.class);
                startActivity(int2);
            }
        });

        Button btnPiso2A = (Button)findViewById(R.id.btnPiso2A);
        btnPiso2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosA.this, banoA2.class);
                startActivity(int2);
            }
        });

        Button btnPiso3A = (Button)findViewById(R.id.btnPiso3A);
        btnPiso3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosA.this, banoA2.class);
                startActivity(int2);
            }
        });

    }
}
