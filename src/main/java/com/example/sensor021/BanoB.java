package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BanoB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bano_b);

        notification notification = new notification();
        notification.notificar(this);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);

        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(BanoB.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton backbtn = (ImageButton)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(BanoB.this, pisosB.class);
                startActivity(int2);

            }
        });
    }
}
