package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pisosB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        notification notification = new notification();
        notification.notificar(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pisos_b);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);
        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(pisosB.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosB.this, Edificios.class);
                startActivity(int2);
            }
        });

        Button btnPiso1B = (Button)findViewById(R.id.btnPiso1B);
        btnPiso1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosB.this, BanoB.class);
                startActivity(int2);
            }
        });

        Button btnPiso2B = (Button)findViewById(R.id.btnPiso2B);
        btnPiso2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosB.this, BanoB.class);
                startActivity(int2);
            }
        });

        Button btnPiso3B = (Button)findViewById(R.id.btnPiso3B);
        btnPiso3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosB.this, BanoB.class);
                startActivity(int2);
            }
        });
    }
}
