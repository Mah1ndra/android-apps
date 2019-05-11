package com.example.mahendra.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InBuiltReceiver extends BroadcastReceiver {
    public void BroadcastReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Battery is low,Please charge",Toast.LENGTH_SHORT).show();
    }


}
