package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pisosD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pisos_d);

        notification notification = new notification();
        notification.notificar(this);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);
        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(pisosD.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosD.this, Edificios.class);
                startActivity(int2);
            }
        });

        Button btnPiso1D = (Button)findViewById(R.id.btnPiso1D);
        btnPiso1D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosD.this, BanoD.class);
                startActivity(int2);
            }
        });

        Button btnPiso2D = (Button)findViewById(R.id.btnPiso2D);
        btnPiso2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosD.this, BanoD.class);
                startActivity(int2);
            }
        });

        Button btnPiso3D = (Button)findViewById(R.id.btnPiso3D);
        btnPiso3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(pisosD.this, BanoD.class);
                startActivity(int2);
            }
        });
    }
}
