package com.example.mahendra.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"Service Created",Toast.LENGTH_SHORT).show();
        Log.i("MySerive","Service Created");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show();
        Log.i("MyService","Service Started");
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_SHORT).show();
        Log.i("MyService","Service Stopped");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
