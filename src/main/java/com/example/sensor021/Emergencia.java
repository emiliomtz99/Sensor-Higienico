package com.example.sensor021;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.annotation.NonNull;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Emergencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);

        notification notification = new notification();
        notification.notificar(this);

        ImageButton back = (ImageButton)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Emergencia.this, Edificios.class);
                startActivity(int2);
            }
        });

        //THINGY
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final TextView Restante = (TextView) findViewById(R.id.Restante);

        DatabaseReference myRef42 = database.getReference("Restante");
        myRef42.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot42) {

                int valueA = dataSnapshot42.getValue(int.class);
                String z = Integer.toString(valueA);

                Restante.setText(z + "%");



                if (valueA == 0) {
                    SimpleDateFormat sdf = new SimpleDateFormat(("HH:MM"));
                    String date = sdf.format(new Date());
                    TextView TIME = (TextView) findViewById(R.id.TIMER);
                    TIME.setText(date);

                    DatabaseReference myRef = database.getReference("HoraCuando0");
                    myRef.setValue(date);
                }
                else{
                    LinearLayout TimeLayout = (LinearLayout)findViewById(R.id.TimeLayout);
                    TimeLayout.setVisibility(TimeLayout.GONE);
                }

                if(valueA == 0 || valueA == 33){
                    Restante.setTextColor(Color.RED);
                }
                else {
                    LinearLayout LLE2 = (LinearLayout)findViewById(R.id.LLE2);
                    LLE2.setVisibility(LLE2.GONE);
                    LinearLayout SpaceLayout = (LinearLayout)findViewById(R.id.SpaceLayout);
                    SpaceLayout.setVisibility(SpaceLayout.GONE);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        //Trabajadores
        DatabaseReference myRefyt = database.getReference("BaseTrabajadorA");
        myRefyt.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valuert = dataSnapshot.getValue(String.class);
                TextView trabajadorE1 = (TextView) findViewById(R.id.trabajadorE1);
                trabajadorE1.setText("Worker: "+ valuert);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        DatabaseReference myRefyt2 = database.getReference("BaseTrabajadorC");
        myRefyt2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valuert = dataSnapshot.getValue(String.class);
                TextView trabajadorE3 = (TextView) findViewById(R.id.trabajadorE2);
                trabajadorE3.setText("Worker: "+ valuert);

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
