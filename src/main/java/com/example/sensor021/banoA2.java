package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class banoA2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        notification notification = new notification();
        notification.notificar(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bano_a2);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);

        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(banoA2.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton backbtn = (ImageButton)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(banoA2.this, pisosA.class);
                startActivity(int2);

            }
        });


    }
}
