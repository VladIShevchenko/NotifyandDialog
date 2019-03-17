package com.example.notifyanddialog;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(MainActivity.this);
                d.setTitle("Login");
                d.setContentView(R.layout.dialog_signin);
                d.show();

                final EditText editUsername = d.findViewById(R.id.username);
                final EditText editPassword = d.findViewById(R.id.password);
                Button btn_mind = d.findViewById(R.id.button_mind);
                Button btn_edit = d.findViewById(R.id.button_edit);
               // final TextView showText=d.findViewById(R.id.text_show);


                btn_mind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       d.cancel();

                    }
                });
                btn_edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title=editUsername.getText().toString();
                        String text=editPassword.getText().toString();
                        notificationCall(title,text);
                    }
                });


            }


        });
    }
    public void notificationCall(String title,String text){
        NotificationCompat.Builder notificationBuilder=(NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_access_alarm_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_attach_money_black_24dp))
                .setContentTitle(title)
                .setContentText(text);

        NotificationManager notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notificationBuilder.build());
    }
}
