package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static androidx.core.content.ContextCompat.getSystemService;

public class Edificios extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edificios);


        notification notification = new notification();
        notification.notificar(this);



                                //USERNAME DATABASE
                                mAuth = FirebaseAuth.getInstance();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                String email = user.getEmail();
                                LinearLayout invisibleLayout = (LinearLayout)findViewById(R.id.invisibleLayout);

                                if(email.equals("emimarbar1@gmail.com") || email.equals("admin@admin.com")){
                                    invisibleLayout.setVisibility(invisibleLayout.VISIBLE);
                                }
                                else{
                                    invisibleLayout.setVisibility(invisibleLayout.GONE);
                                }



        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);

        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Edificios.this, Emergencia.class);
                startActivity(int1);
            }
        });


        Button BtnEdificioA = (Button)findViewById(R.id.btnEdificioA);

        BtnEdificioA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Edificios.this, pisosA.class);
                startActivity(int2);
            }
        });

        Button BtnEdificioB = (Button)findViewById(R.id.btnEdificioB);

        BtnEdificioB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(Edificios.this, pisosB.class);
                startActivity(int3);
            }
        });

        Button BtnEdificioC = (Button)findViewById(R.id.btnEdificioC);

        BtnEdificioC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(Edificios.this, pisosC.class);
                startActivity(int4);
            }
        });

        Button BtnEdificioD = (Button)findViewById(R.id.btnEdificioD);

        BtnEdificioD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(Edificios.this, pisosD.class);
                startActivity(int5);
            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(Edificios.this, LogIn.class);
                startActivity(int6);
            }
        });




                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    //PARA ED.A
                    DatabaseReference myRefA = database.getReference("BaseTrabajadorA");
                    myRefA.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String valueA = dataSnapshot.getValue(String.class);
                            TextView trabajadorA = (TextView) findViewById(R.id.trabajadorA);
                            trabajadorA.setText(valueA);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });

                    //PARA ED.B
                    DatabaseReference myRefB = database.getReference("BaseTrabajadorB");
                    myRefB.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String valueB = dataSnapshot.getValue(String.class);
                            TextView trabajadorB = (TextView) findViewById(R.id.trabajadorB);
                            trabajadorB.setText(valueB);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });

                    //PARA ED.C
                    DatabaseReference myRefC = database.getReference("BaseTrabajadorC");
                    myRefC.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String valueC = dataSnapshot.getValue(String.class);
                            TextView trabajadorC = (TextView) findViewById(R.id.trabajadorC);
                            trabajadorC.setText(valueC);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });

                    //PARA ED.D
                    DatabaseReference myRefD = database.getReference("BaseTrabajadorD");
                    myRefD.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String valueD = dataSnapshot.getValue(String.class);
                            TextView trabajadorD = (TextView) findViewById(R.id.trabajadorD);
                            trabajadorD.setText(valueD);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });


        Button btnTrabajadores = (Button)findViewById(R.id.btnTrabajadores);
        btnTrabajadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Edificios.this, trabajadores.class);
                startActivity(int1);
            }
        });


        Button Reportes = (Button) findViewById(R.id.reportes);
        Reportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intn = new Intent(Edificios.this, Reportes.class);
                startActivity(intn);
            }
        });


    }
}
