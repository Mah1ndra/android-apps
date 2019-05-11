package com.example.mahendra.brocastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Custom Broadcast invoked: Second",Toast.LENGTH_SHORT).show();
    }
}
