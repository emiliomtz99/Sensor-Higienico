package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;

import org.w3c.dom.Text;


public class banoA1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "EJEMPLO TAG");

        notification notification = new notification();
        notification.notificar(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bano_a_1);
        TextView Restante = (TextView) findViewById(R.id.Restante);
        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);

        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(banoA1.this, Emergencia.class);
                startActivity(int1);

            }
        });

        ImageButton backbtn = (ImageButton)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(banoA1.this, pisosA.class);
                startActivity(int2);

            }
        });

        //DATA BASE TO GET RESTANTE Ya inicializado como textView

        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();

        TextView Restante0 = (TextView) findViewById(R.id.Restante0);



    DatabaseReference myRef42 = database2.getReference("Restante");       //porcentaje



    myRef42.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot42) {
    final int valueA = dataSnapshot42.getValue(int.class);
    String z = Integer.toString(valueA);


        TextView Restante0 = (TextView) findViewById(R.id.Restante0);
                Restante0.setText(z + "%");

                                                DatabaseReference myRefA = database2.getReference("BaseTrabajadorA"); //trabajador
                                                myRefA.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    final String valueTrabajador = dataSnapshot.getValue(String.class);


                                                                TextView AHH = (TextView) findViewById(R.id.AHH);
                                                                AHH.setText(valueTrabajador);


                                                                if (valueA == 0) {

                                                                    TextView Restante0 = (TextView) findViewById(R.id.Restante0);
                                                                    Restante0.setTextColor(Color.RED);

                                                                    DatabaseReference myRefTrabajador = database2.getReference(valueTrabajador);


                                                                    SimpleDateFormat DiayHora = new SimpleDateFormat(("dd-MMM-aaaa-HH:MM"));
                                                                    String date = DiayHora.format(new Date());


                                                                    DatabaseReference myRef = database2.getReference("DiaHoraDB");
                                                                    myRef.setValue(date);
                                                                }
                                                                else{
                                                                    LinearLayout InvisibleLayout = (LinearLayout)findViewById(R.id.InvisibleLayout);
                                                                    InvisibleLayout.setVisibility(InvisibleLayout.GONE);
                                                                }

                                                                if(valueA == 100 || valueA == 66){
                                                                    TextView Restante0 = (TextView) findViewById(R.id.Restante0);
                                                                    Restante0.setTextColor(Color.GREEN);
                                                                }
                                                                if(valueA == 33){
                                                                    TextView Restante0 = (TextView) findViewById(R.id.Restante0);
                                                                    Restante0.setTextColor(Color.YELLOW);
                                                                }

                                                                else {
                                                                    LinearLayout InvisibleLayout = (LinearLayout)findViewById(R.id.InvisibleLayout);
                                                                    InvisibleLayout.setVisibility(InvisibleLayout.GONE);
                                                                }
                                                            }

                                    @Override
                                    public void onCancelled(DatabaseError error) {
                                        // Failed to read value
                                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                });



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                toast.show();
            }
        });







    }


}
