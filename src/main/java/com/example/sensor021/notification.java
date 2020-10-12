package com.example.sensor021;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static androidx.core.content.ContextCompat.getSystemService;

public class notification {
    private NotificationManagerCompat notificationManager;
    public void notificar(final Context other){



        FirebaseDatabase databaseNot = FirebaseDatabase.getInstance();
        DatabaseReference myRefNotifica = databaseNot.getReference("boton");
        myRefNotifica.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int value = dataSnapshot.getValue(int.class);

                    if (value==666){
                        on(other);
                        listo();
                    }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }

    public void on(Context other){

        long[] pattern = {500,500,500,500,500,500,500,500,500};
        notificationManager = NotificationManagerCompat.from(other);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new NotificationCompat.Builder(other, App.CHANNEL_1_ID)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setSmallIcon(R.drawable.ic_bathroom)
                .setContentTitle("Panico")
                .setContentText("En el Edificio A, piso 1, cabina 1")
                .setSound(uri)
                .setVibrate(pattern)

                .build();
        notificationManager.notify(1,notification);
    }

    public void listo(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("boton");

        myRef.setValue(0);
    }
}
