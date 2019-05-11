package com.example.networkcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button NetCheck;
    ConnectionDiscover cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetCheck = (Button) findViewById(R.id.NetCheck);
        cd = new ConnectionDiscover(this);
        NetCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cd.isConnected()){
                    Toast.makeText(MainActivity.this,"Connected!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Not Connected!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
