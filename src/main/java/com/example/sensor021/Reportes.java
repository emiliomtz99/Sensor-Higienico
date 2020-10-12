package com.example.sensor021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reportes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        Button emergenciaButton = (Button)findViewById(R.id.emergenciaButton);

        emergenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Reportes.this, Emergencia.class);
                startActivity(int1);

            }
        });

        data data = new data();
        data.ReadFromDB();
        notification notification = new notification();
        notification.notificar(this);


        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(Reportes.this, Edificios.class);
                startActivity(int6);
            }
        });

        //////////////////////////////////////////////////////////////////////////BOTONES JABON/PAPEL///////////////////////////////////////////////////
        final int color1 = Color.parseColor("#98dce8");
        final int color2 = Color.parseColor("#aebcaf");
        final Button JabonBtn = (Button) findViewById(R.id.JabonBtn);
        final Button PapelBtn = (Button) findViewById(R.id.PapelBtn);

        LinearLayout LayoutPap = (LinearLayout) findViewById(R.id.LayoutPap);
        LayoutPap.setVisibility(LayoutPap.GONE);
        LinearLayout LayoutJab = (LinearLayout) findViewById(R.id.LayoutJab);
        LayoutJab.setVisibility(LayoutJab.GONE);

        JabonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout LayoutJab = (LinearLayout) findViewById(R.id.LayoutJab);
                LayoutJab.setVisibility(LayoutJab.VISIBLE);

                LinearLayout LayoutPap = (LinearLayout) findViewById(R.id.LayoutPap);
                LayoutPap.setVisibility(LayoutPap.GONE);

                JabonBtn.setBackgroundColor(color1);
                PapelBtn.setBackgroundColor(color2);

            }
        });

        PapelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout LayoutJab = (LinearLayout) findViewById(R.id.LayoutJab);
                LayoutJab.setVisibility(LayoutJab.GONE);

                LinearLayout LayoutPap = (LinearLayout) findViewById(R.id.LayoutPap);
                LayoutPap.setVisibility(LayoutPap.VISIBLE);

                JabonBtn.setBackgroundColor(color2);
                PapelBtn.setBackgroundColor(color1);

            }
        });




        ///////////////////////////////////////////////////////////DATOS JABON///////////////////////////////////////////////////////////////////////////////
        final FirebaseDatabase databasej = FirebaseDatabase.getInstance();
        final TextView inv_totalJab = (TextView) findViewById(R.id.inv_totalJab); // Se muestre cuantos rollos quedan...

        DatabaseReference myRef4 = databasej.getReference("InventarioJab");
        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot4) {
                final int valueA = dataSnapshot4.getValue(int.class);
                String z = Integer.toString(valueA);
                inv_totalJab.setText(z);

                Button addbtnJab = (Button) findViewById(R.id.addbtnJab);         //Cuando le clickeass el boton se suman a la cuantos quedan la cantidad dada en addtxt
                addbtnJab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText addtxtJab = (EditText) findViewById(R.id.addtxtJab);
                        int addint = Integer.parseInt(addtxtJab.getText().toString());
                        int suma = valueA + addint;
                        //inv_total.setText((suma));
                        DatabaseReference myRefB = databasej.getReference("InventarioJab"); // Se edita la base de datos y cambia al cambiar se repite el proceso
                        myRefB.setValue(suma);
                        addtxtJab.setText("0");


                    }
                });


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button personaBtnJab = (Button) findViewById(R.id.personaBtnJab);
        personaBtnJab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout DatosJab = (LinearLayout) findViewById(R.id.DatosJab);
                DatosJab.setVisibility(DatosJab.VISIBLE);


                final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
                //////////////////////////////////////////////////////PERSONA1/////////////////////////////////////////////////////
                DatabaseReference myRef42 = database2.getReference("BaseTrabajadorA");
                myRef42.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot42) {
                        final String persona1 = dataSnapshot42.getValue(String.class);
                        TextView textView1PL = (TextView) findViewById(R.id.textView1PLJab);
                        textView1PL.setText(persona1);
                        persona2(persona1);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });


                //////////////////////////////////////////////////////PERSONA1/////////////////////////////////////////////////////
                DatabaseReference myRef49 = database2.getReference("BaseTrabajadorB");
                myRef49.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot49) {
                        final String persona1 = dataSnapshot49.getValue(String.class);
                        TextView textView1PL = (TextView) findViewById(R.id.textView2PLJab);
                        textView1PL.setText(persona1);
                        persona2(persona1);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                DatabaseReference myRef50 = database2.getReference("BaseTrabajadorC");
                myRef50.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot50) {
                        final String persona1 = dataSnapshot50.getValue(String.class);
                        TextView textView1PL = (TextView) findViewById(R.id.textView3PLJab);
                        textView1PL.setText(persona1);
                        persona2(persona1);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                DatabaseReference myRef51 = database2.getReference("BaseTrabajadorD");
                myRef51.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot51) {
                        final String persona1 = dataSnapshot51.getValue(String.class);
                        TextView textView1PL = (TextView) findViewById(R.id.textView4PLJab);
                        textView1PL.setText(persona1);
                        persona2(persona1);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                TextView textView5PL = (TextView) findViewById(R.id.textView5PLJab);
                textView5PL.setText("");
                TextView textView6PL = (TextView) findViewById(R.id.textView6PLJab);
                textView6PL.setText("");


                TextView textView1PRJab = (TextView) findViewById(R.id.textView1PRJab);
                textView1PRJab.setText("22");
                TextView textView2PRJab = (TextView) findViewById(R.id.textView2PRJab);
                textView2PRJab.setText("33");
                TextView textView3PRJab = (TextView) findViewById(R.id.textView3PRJab);
                textView3PRJab.setText("24");
                TextView textView4PRJab = (TextView) findViewById(R.id.textView4PRJab);
                textView4PRJab.setText("58");
                TextView textView5PRJab = (TextView) findViewById(R.id.textView5PRJab);
                textView5PRJab.setText("");
                TextView textView6PRJab = (TextView) findViewById(R.id.textView6PRJab);
                textView6PRJab.setText("");


            }
        });


        Button semanaBtnJab = (Button) findViewById(R.id.semanaBtnJab);
        semanaBtnJab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout DatosJab = (LinearLayout) findViewById(R.id.DatosJab);
                DatosJab.setVisibility(DatosJab.VISIBLE);

                TextView textView1PLJab = (TextView) findViewById(R.id.textView1PLJab);
                textView1PLJab.setText("1");
                TextView textView2PLJab = (TextView) findViewById(R.id.textView2PLJab);
                textView2PLJab.setText("2");
                TextView textView3PLJab = (TextView) findViewById(R.id.textView3PLJab);
                textView3PLJab.setText("3");
                TextView textView4PLJab = (TextView) findViewById(R.id.textView4PLJab);
                textView4PLJab.setText("4");
                TextView textView5PLJab = (TextView) findViewById(R.id.textView5PLJab);
                textView5PLJab.setText("5");
                TextView textView6PLJab = (TextView) findViewById(R.id.textView6PLJab);
                textView6PLJab.setText("");

                TextView textView1PRJab = (TextView) findViewById(R.id.textView1PRJab);
                textView1PRJab.setText("5");
                TextView textView2PRJab = (TextView) findViewById(R.id.textView2PRJab);
                textView2PRJab.setText("9");
                TextView textView3PRJab = (TextView) findViewById(R.id.textView3PRJab);
                textView3PRJab.setText("15");
                TextView textView4PRJab = (TextView) findViewById(R.id.textView4PRJab);
                textView4PRJab.setText("13");
                TextView textView5PRJab = (TextView) findViewById(R.id.textView5PRJab);
                textView5PRJab.setText("22");
                TextView textView6PRJab = (TextView) findViewById(R.id.textView6PRJab);
                textView6PRJab.setText("");
            }
        });



        Button turno = (Button) findViewById(R.id.turnoBtnJab);
        turno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout DatosJab = (LinearLayout) findViewById(R.id.DatosJab);
                DatosJab.setVisibility(DatosJab.VISIBLE);

                TextView textView1PLJab = (TextView) findViewById(R.id.textView1PLJab);
                textView1PLJab.setText("Morning");
                TextView textView2PLJab = (TextView) findViewById(R.id.textView2PLJab);
                textView2PLJab.setText("Afternoon");
                TextView textView3PLJab = (TextView) findViewById(R.id.textView3PLJab);
                textView3PLJab.setText("Night");
                TextView textView4PLJab = (TextView) findViewById(R.id.textView4PLJab);
                textView4PLJab.setText("Early Morning");
                TextView textView5PLJab = (TextView) findViewById(R.id.textView5PLJab);
                textView5PLJab.setText("");
                TextView textView6PLJab = (TextView) findViewById(R.id.textView6PLJab);
                textView6PLJab.setText("");

                TextView textView1PRJab = (TextView) findViewById(R.id.textView1PRJab);
                textView1PRJab.setText("6");
                TextView textView2PRJab = (TextView) findViewById(R.id.textView2PRJab);
                textView2PRJab.setText("6");
                TextView textView3PRJab = (TextView) findViewById(R.id.textView3PRJab);
                textView3PRJab.setText("9");
                TextView textView4PRJab = (TextView) findViewById(R.id.textView4PRJab);
                textView4PRJab.setText("2");
                TextView textView5PRJab = (TextView) findViewById(R.id.textView5PRJab);
                textView5PRJab.setText("");
                TextView textView6PRJab = (TextView) findViewById(R.id.textView6PRJab);
                textView6PRJab.setText("");
            }
        });

        Button Mes = (Button) findViewById(R.id.mesBtnJab);
        Mes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout DatosJab = (LinearLayout) findViewById(R.id.DatosJab);
                DatosJab.setVisibility(DatosJab.VISIBLE);

                TextView textView1PLJab = (TextView) findViewById(R.id.textView1PLJab);
                textView1PLJab.setText("January");
                TextView textView2PLJab = (TextView) findViewById(R.id.textView2PLJab);
                textView2PLJab.setText("February");
                TextView textView3PLJab = (TextView) findViewById(R.id.textView3PLJab);
                textView3PLJab.setText("March");
                TextView textView4PLJab = (TextView) findViewById(R.id.textView4PLJab);
                textView4PLJab.setText("April");
                TextView textView5PLJab = (TextView) findViewById(R.id.textView5PLJab);
                textView5PLJab.setText("May");
                TextView textView6PLJab = (TextView) findViewById(R.id.textView6PLJab);
                textView6PLJab.setText("June");

                TextView textView1PRJab = (TextView) findViewById(R.id.textView1PRJab);
                textView1PRJab.setText("16");
                TextView textView2PRJab = (TextView) findViewById(R.id.textView2PRJab);
                textView2PRJab.setText("61");
                TextView textView3PRJab = (TextView) findViewById(R.id.textView3PRJab);
                textView3PRJab.setText("92");
                TextView textView4PRJab = (TextView) findViewById(R.id.textView4PRJab);
                textView4PRJab.setText("25");
                TextView textView5PRJab = (TextView) findViewById(R.id.textView5PRJab);
                textView5PRJab.setText("100");
                TextView textView6PRJab = (TextView) findViewById(R.id.textView6PRJab);
                textView6PRJab.setText("3");
            }
        });

                //PAPEL//////////////////////////////////////////////////////////////////////////////
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        final TextView inv_total = (TextView) findViewById(R.id.inv_total); // Se muestre cuantos rollos quedan...

        DatabaseReference myRef42 = database2.getReference("Inventario");
        myRef42.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot42) {
                final int valueA = dataSnapshot42.getValue(int.class);
                String z = Integer.toString(valueA);
                inv_total.setText(z);

                Button addbtn = (Button) findViewById(R.id.addbtn);         //Cuando le clickeass el boton se suman a la cuantos quedan la cantidad dada en addtxt
                addbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText addtxt = (EditText) findViewById(R.id.addtxt);
                        int addint = Integer.parseInt(addtxt.getText().toString());
                        int suma = valueA + addint;
                        //inv_total.setText((suma));
                        DatabaseReference myRefB = database2.getReference("Inventario"); // Se edita la base de datos y cambia al cambiar se repite el proceso
                        myRefB.setValue(suma);
                        addtxt.setText("0");


                    }
                });


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        ////////////////////////////////////////////////////BOTONES///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////PERSONA/////////////////////////////////////////////////////
        Button personaBtn = (Button) findViewById(R.id.personaBtn);
        personaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout Datos = (LinearLayout) findViewById(R.id.Datos);
                Datos.setVisibility(Datos.VISIBLE);

                persona1();
            }
        });



        ///////////////////////////////////////////////////////Turno/////////////////////////////////////////////////////
        Button turnoBtn = (Button) findViewById(R.id.turnoBtn);
        turnoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout Datos = (LinearLayout) findViewById(R.id.Datos);
                Datos.setVisibility(Datos.VISIBLE);

                TextView textView1PL = (TextView) findViewById(R.id.textView1PL);
                textView1PL.setText("Morning");
                TextView textView2PL = (TextView) findViewById(R.id.textView2PL);
                textView2PL.setText("Afternoon");
                TextView textView3PL = (TextView) findViewById(R.id.textView3PL);
                textView3PL.setText("Night");
                TextView textView4PL = (TextView) findViewById(R.id.textView4PL);
                textView4PL.setText("Early Morning");
                TextView textView5PL = (TextView) findViewById(R.id.textView5PL);
                textView5PL.setText("");
                TextView textView6PL = (TextView) findViewById(R.id.textView6PL);
                textView6PL.setText("");

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("turno/manana");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView1PR = (TextView) findViewById(R.id.textView1PR);
                        textView1PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef2 = database.getReference("turno/tarde");
                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView2PR = (TextView) findViewById(R.id.textView2PR);
                        textView2PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef3 = database.getReference("turno/noche");
                myRef3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView3PR = (TextView) findViewById(R.id.textView3PR);
                        textView3PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef4 = database.getReference("turno/madrugada");
                myRef4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView4PR = (TextView) findViewById(R.id.textView4PR);
                        textView4PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });





                TextView textView5PR = (TextView) findViewById(R.id.textView5PR);
                textView5PR.setText("");
                TextView textView6PR = (TextView) findViewById(R.id.textView6PR);
                textView6PR.setText("");
            }
        });
        ///////////////////////////////////////////////////////semana/////////////////////////////////////////////////////
        Button semanaBtn = (Button) findViewById(R.id.semanaBtn);
        semanaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                LinearLayout Datos = (LinearLayout) findViewById(R.id.Datos);
                Datos.setVisibility(Datos.VISIBLE);

                TextView textView1PL = (TextView) findViewById(R.id.textView1PL);
                textView1PL.setText("1.-");
                TextView textView2PL = (TextView) findViewById(R.id.textView2PL);
                textView2PL.setText("2.-");
                TextView textView3PL = (TextView) findViewById(R.id.textView3PL);
                textView3PL.setText("3.-");
                TextView textView4PL = (TextView) findViewById(R.id.textView4PL);
                textView4PL.setText("4.-");
                TextView textView5PL = (TextView) findViewById(R.id.textView5PL);
                textView5PL.setText("5.-");
                TextView textView6PL = (TextView) findViewById(R.id.textView6PL);
                textView6PL.setText("");
                TextView textView6PR = (TextView) findViewById(R.id.textView6PR);
                textView6PR.setText("");


                DatabaseReference myRef = database.getReference("Semana/1");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView1PR = (TextView) findViewById(R.id.textView1PR);
                        textView1PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef2 = database.getReference("Semana/2");
                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView2PR = (TextView) findViewById(R.id.textView2PR);
                        textView2PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef3 = database.getReference("Semana/3");
                myRef3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView3PR = (TextView) findViewById(R.id.textView3PR);
                        textView3PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef4 = database.getReference("Semana/4");
                myRef4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView4PR = (TextView) findViewById(R.id.textView4PR);
                        textView4PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef5 = database.getReference("Semana/5");
                myRef5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView5PR = (TextView) findViewById(R.id.textView5PR);
                        textView5PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });



            }
        });
        ///////////////////////////////////////////////////////MES/////////////////////////////////////////////////////
        Button mesBtn = (Button) findViewById(R.id.mesBtn);
        mesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout Datos = (LinearLayout) findViewById(R.id.Datos);
                Datos.setVisibility(Datos.VISIBLE);

                TextView textView1PL = (TextView) findViewById(R.id.textView1PL);
                textView1PL.setText("January");
                TextView textView2PL = (TextView) findViewById(R.id.textView2PL);
                textView2PL.setText("February");
                TextView textView3PL = (TextView) findViewById(R.id.textView3PL);
                textView3PL.setText("March");
                TextView textView4PL = (TextView) findViewById(R.id.textView4PL);
                textView4PL.setText("April");
                TextView textView5PL = (TextView) findViewById(R.id.textView5PL);
                textView5PL.setText("May");
                TextView textView6PL = (TextView) findViewById(R.id.textView6PL);
                textView6PL.setText("June");

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Mes/January");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView1PR = (TextView) findViewById(R.id.textView1PR);
                        textView1PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef2 = database.getReference("Mes/February");
                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView2PR = (TextView) findViewById(R.id.textView2PR);
                        textView2PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef3 = database.getReference("Mes/March");
                myRef3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView3PR = (TextView) findViewById(R.id.textView3PR);
                        textView3PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef4 = database.getReference("Mes/April");
                myRef4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView4PR = (TextView) findViewById(R.id.textView4PR);
                        textView4PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef5 = database.getReference("Mes/May");
                myRef5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView5PR = (TextView) findViewById(R.id.textView5PR);
                        textView5PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                DatabaseReference myRef6 = database.getReference("Mes/June");
                myRef6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        int value = dataSnapshot.getValue(int.class);
                        TextView textView6PR = (TextView) findViewById(R.id.textView6PR);
                        textView6PR.setText(Integer.toString(value));
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });


            }
            });
    }

    public void persona1() {
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        //////////////////////////////////////////////////////PERSONA1/////////////////////////////////////////////////////
        DatabaseReference myRef42 = database2.getReference("BaseTrabajadorA");
        myRef42.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot42) {
                final String persona1 = dataSnapshot42.getValue(String.class);
                TextView textView1PL = (TextView) findViewById(R.id.textView1PL);
                textView1PL.setText(persona1);
                persona2(persona1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void persona2(final String persona1)

    {
        //////////////////////////////////////////////////////PERSONA2/////////////////////////////////////////////////////
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef43 = database2.getReference("BaseTrabajadorB");
        myRef43.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot43) {
                final String persona2 = dataSnapshot43.getValue(String.class);
                TextView textView2PL = (TextView) findViewById(R.id.textView2PL);
                textView2PL.setText(persona2);
                persona3(persona1, persona2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    public void persona3(final String persona1, final String persona2) {
        //////////////////////////////////////////////////////PERSONA3/////////////////////////////////////////////////////
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef44 = database2.getReference("BaseTrabajadorC");
        myRef44.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot44) {
                final String persona3 = dataSnapshot44.getValue(String.class);
                TextView textView3PL = (TextView) findViewById(R.id.textView3PL);
                textView3PL.setText(persona3);
                persona4(persona1,persona2,persona3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


    //////////////////////////////////////////////////////PERSONA4/////////////////////////////////////////////////////
    public void persona4(final String persona1, final String persona2, final String persona3) {
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef45 = database2.getReference("BaseTrabajadorD");
        myRef45.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot45) {
                final String persona4 = dataSnapshot45.getValue(String.class);
                TextView textView4PL = (TextView) findViewById(R.id.textView4PL);
                textView4PL.setText(persona4);
                datosPersona(persona1, persona2, persona3, persona4);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        TextView textView5PL = (TextView) findViewById(R.id.textView5PL);
        textView5PL.setText("");
        TextView textView6PL = (TextView) findViewById(R.id.textView6PL);
        textView6PL.setText("");
    }
        //////////////////////////////////////////////////////DATOS PERSONA/////////////////////////////////////////////////////

        public void datosPersona(final String persona1, final String persona2, final String persona3, final String persona4)
    {
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        ////Datos persona 1

        DatabaseReference myRefo = database2.getReference(persona1);
        myRefo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot45) {
                final int datapersona1 = dataSnapshot45.getValue(int.class);
                TextView textView1PR = (TextView) findViewById(R.id.textView1PR);
                textView1PR.setText(Integer.toString(datapersona1));
                Log.d("TAG", "WOO");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        DatabaseReference myRef01 = database2.getReference(persona2);
        myRef01.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot45) {
                final int datapersona2 = dataSnapshot45.getValue(int.class);
                TextView textView2PR = (TextView) findViewById(R.id.textView2PR);
                textView2PR.setText(Integer.toString(datapersona2));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        DatabaseReference myRef02 = database2.getReference(persona3);
        myRef02.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot45) {
                final int datapersona3 = dataSnapshot45.getValue(int.class);
                TextView textView3PR = (TextView) findViewById(R.id.textView3PR);
                textView3PR.setText(Integer.toString(datapersona3));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        DatabaseReference myRef03 = database2.getReference(persona4);
        myRef03.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot45) {
                final int datapersona4 = dataSnapshot45.getValue(int.class);
                TextView textView4PR = (TextView) findViewById(R.id.textView4PR);
                textView4PR.setText(Integer.toString(datapersona4));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });




        TextView textView5PR = (TextView) findViewById(R.id.textView5PR);
        textView5PR.setText("");
        TextView textView6PR = (TextView) findViewById(R.id.textView6PR);
        textView6PR.setText("");
        }

}
