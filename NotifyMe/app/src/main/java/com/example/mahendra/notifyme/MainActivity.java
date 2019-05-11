package com.example.mahendra.notifyme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int NOTIFICATION_ID=0;
    final static String guideUrl = "https://developer.android.com/design/patterns/notifications.html";
    private static final String ACTION_UPDATE_NOTIFICATION = "com.example.android.notifyme.ACTION_UPDATE_NOTIFICATION";
    Button b1,update,cancel;
    private NotificationManager mNotifyManager;
    private NotificationReceiver mReceiver = new NotificationReceiver();


    public void sendNotification(){

        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent learnMoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(guideUrl));

        PendingIntent learnMorePendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,learnMoreIntent,PendingIntent.FLAG_ONE_SHOT);


        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        b1.setEnabled(false);
        update.setEnabled(true);
        cancel.setEnabled(true);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("You've been Notified!")
                .setContentText("This is your Notification Text.")
                .setSmallIcon(R.drawable.android_notify)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .addAction(R.drawable.ic_update, "Update", updatePendingIntent)
                .addAction(R.drawable.ic_learn_more,"Learn More",learnMorePendingIntent)
                .setContentIntent(notificationPendingIntent);
        Notification myNotification = notifyBuilder.build();
        mNotifyManager.notify(NOTIFICATION_ID,myNotification);




    }

    public void updateNotification(){
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        registerReceiver(mReceiver,new IntentFilter(ACTION_UPDATE_NOTIFICATION));
        Intent learnMoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(guideUrl));

        PendingIntent learnMorePendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,learnMoreIntent,PendingIntent.FLAG_ONE_SHOT);

        Bitmap androidImage = BitmapFactory.decodeResource(getResources(),R.drawable.mascot_1);
        b1.setEnabled(false);
        update.setEnabled(false);
        cancel.setEnabled(true);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("You've been Notified!")
                .setContentText("This is your Notification Text.")
                .setSmallIcon(R.drawable.android_notify)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(androidImage)
                .setBigContentTitle("Notification Updated!"))
                .addAction(R.drawable.ic_learn_more,"Learn More",learnMorePendingIntent)
                .setContentIntent(notificationPendingIntent);

        mNotifyManager.notify(NOTIFICATION_ID,notifyBuilder.build());
    }

    public void cancelNotification(){
        mNotifyManager.cancel(NOTIFICATION_ID);
        b1.setEnabled(true);
        update.setEnabled(false);
        cancel.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.notify);
        update = (Button)findViewById(R.id.update);
        cancel = (Button)findViewById(R.id.cancel);
        b1.setEnabled(true);
        update.setEnabled(false);
        cancel.setEnabled(false);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNotification();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
            }
        });
    }

    @Override
    protected void onDestroy() {

        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public class NotificationReceiver extends BroadcastReceiver{
        public NotificationReceiver(){}
        @Override
        public void onReceive(Context context, Intent intent) {
            updateNotification();
        }


    }

    @Override
    public void onClick(View view) {

    }
}
