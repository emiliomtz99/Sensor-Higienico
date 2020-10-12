package com.example.sensor021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class trabajadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajadores);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);

        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(trabajadores.this, Emergencia.class);
                startActivity(int1);

            }
        });

        notification notification = new notification();
        notification.notificar(this);


        Button Aceparbtn = (Button) findViewById(R.id.aceptarbtn);

        Aceparbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                EditText txtTrabajadorA = (EditText) findViewById(R.id.txtTrabajadorA);
                EditText txtTrabajadorB = (EditText) findViewById(R.id.txtTrabajadorB);
                EditText txtTrabajadorC = (EditText) findViewById(R.id.txtTrabajadorC);
                EditText txtTrabajadorD = (EditText) findViewById(R.id.txtTrabajadorD);

                String trabajadorA = txtTrabajadorA.getText().toString();
                String trabajadorB = txtTrabajadorB.getText().toString();
                String trabajadorC = txtTrabajadorC.getText().toString();
                String trabajadorD = txtTrabajadorD.getText().toString();

                if (trabajadorA.matches("") || trabajadorB.matches("") || trabajadorC.matches("") || trabajadorD.matches("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Missing Data", Toast.LENGTH_SHORT);
                    toast.show();

                }else{

                    DatabaseReference myRef = database.getReference("BaseTrabajadorA");
                    myRef.setValue(trabajadorA);
                    DatabaseReference myRef2 = database.getReference(trabajadorA);
                    myRef2.setValue(0);


                    DatabaseReference myRefB = database.getReference("BaseTrabajadorB");
                    myRefB.setValue(trabajadorB);
                    DatabaseReference myRef3 = database.getReference(trabajadorB);
                    myRef3.setValue(0);

                    DatabaseReference myRefC = database.getReference("BaseTrabajadorC");
                    myRefC.setValue(trabajadorC);
                    DatabaseReference myRef4 = database.getReference(trabajadorC);
                    myRef4.setValue(0);

                    DatabaseReference myRefD = database.getReference("BaseTrabajadorD");
                    myRefD.setValue(trabajadorD);
                    DatabaseReference myRef5 = database.getReference(trabajadorD);
                    myRef5.setValue(0);

                    Intent int1 = new Intent(trabajadores.this, Edificios.class);
                    startActivity(int1);

                    Toast toast = Toast.makeText(getApplicationContext(), "Data updated", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        ImageButton back = (ImageButton)findViewById(R.id.back0);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(trabajadores.this, Edificios.class);
                startActivity(int3);
            }
        });

    }

}







