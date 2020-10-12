package com.example.sensor021;
import android.util.Log;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class data {
    boolean executed = false;

    public void ReadFromDB() {

        ReadFromDBNRestante();

       //FirebaseDatabase database = FirebaseDatabase.getInstance();DatabaseReference myRefname = database.getReference("Ash Ketchup");myRefname.setValue(2);

    }


    public void ReadFromDBNRestante() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefC = database.getReference("Restante");
        myRefC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final int Restante = dataSnapshot.getValue(int.class);
                ReadFromDBNAme(Restante);

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }

    public void ReadFromDBNAme(final int Restante) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("BaseTrabajadorA");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    String trabajador = dataSnapshot.getValue(String.class);
                    ReadFromDBRollos(trabajador, Restante);
                }

                @Override
                public void onCancelled(DatabaseError error) {


                }
            });
        }



    public void ReadFromDBRollos(final String name, final int Restante) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef222 = database.getReference(name);

        myRef222.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final int Rollo = dataSnapshot.getValue(int.class);

                inventario(name, Restante, Rollo);


            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

    }

    public void inventario(final String name,final int Restante,final  int Rollo) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef222 = database.getReference("Inventario");

        myRef222.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final int inventario = dataSnapshot.getValue(int.class);
                mes(name, Restante, Rollo, inventario);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

    }

    public void mes(final String name,final int Restante,final  int Rollo, final int inventario) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        SimpleDateFormat month = new SimpleDateFormat(("MMMM"));
        String monthSo = month.format(new Date());
        final  String monthS = "Mes/"+monthSo;

        DatabaseReference myRef224 = database.getReference(monthS);
        myRef224.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int mesInt = dataSnapshot.getValue(int.class);

                Log.d("TAG", (monthS));
               week(name, Restante, Rollo, inventario, mesInt, monthS);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

    }

    public void week(final String name,final int Restante,final  int Rollo,final int inventario,final int mes,final String monthS) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        SimpleDateFormat weeks = new SimpleDateFormat(("W"));
        String week = weeks.format(new Date());

        final  String weekr = "Semana/"+week;



        DatabaseReference myRef224 = database.getReference(weekr);
        myRef224.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int weekint = dataSnapshot.getValue(int.class);


                hora(name, Restante, Rollo, inventario, mes, monthS, weekint, weekr);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

    }


    public void hora(final String name,final int Restante,final  int Rollo,final int inventario,final int mes,final String monthS,final int week,final String weekr) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        SimpleDateFormat horas = new SimpleDateFormat(("k"));
        String horaS = horas.format(new Date());
        int hora = Integer.parseInt(horaS);


        if (hora >= 7 && hora <= 12) {
            final String turno = "turno/manana";
            DatabaseReference myRef224 = database.getReference(turno);
            myRef224.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int horaint = dataSnapshot.getValue(int.class);


                    edit(name, Restante, Rollo, inventario, mes, monthS, week, weekr, horaint, turno);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });


        }
        if (hora >= 13 && hora <= 17) {
            final String turno = "turno/tarde";
            DatabaseReference myRef224 = database.getReference(turno);
            myRef224.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int horaint = dataSnapshot.getValue(int.class);


                    edit(name, Restante, Rollo, inventario, mes, monthS, week, weekr, horaint, turno);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });
        }

        if (hora >= 18 && hora <= 22) {
            final String turno = "turno/noche";
            DatabaseReference myRef224 = database.getReference(turno);
            myRef224.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int horaint = dataSnapshot.getValue(int.class);


                    edit(name, Restante, Rollo, inventario, mes, monthS, week, weekr, horaint, turno);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });
        }

        if (hora >=23  || hora <= 6) {
            final String turno = "turno/madrugada";
            DatabaseReference myRef224 = database.getReference(turno);
            myRef224.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int horaint = dataSnapshot.getValue(int.class);


                    edit(name, Restante, Rollo, inventario, mes, monthS, week, weekr, horaint, turno);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });
        }
    }












    public void edit(String name, int Restante,  int Rollo, int inventario, int mes, String monthS, int week, String weekr, int horaint, String turno) {
        Log.d("TAG", Integer.toString(Restante));
        Log.d("TAG", (name));
        Log.d("TAG", Integer.toString(Rollo));



            if(!executed && Restante == 0) {
                executed = true;
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                DatabaseReference myRefname = database.getReference(name);
                myRefname.setValue(Rollo +1);

                DatabaseReference myRefInv = database.getReference("Inventario");
                myRefInv.setValue(inventario - 1);

                DatabaseReference myRefmes = database.getReference(monthS);
                myRefmes.setValue(mes + 1);

                DatabaseReference myRefweek = database.getReference(weekr);
                myRefweek.setValue(week + 1);

                DatabaseReference myRefturno = database.getReference(turno);
                myRefturno.setValue(horaint + 1);



            }
       }

}