package com.example.mahendra.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view){
        switch(view.getId()){
            case R.id.web:
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://android.com"));
                startActivity(i1);
                break;

            case R.id.tel:
                Intent i2 = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:9966996677"));
                startActivity(i2);
                break;

            case R.id.geo:
                Intent i3 = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:-122.078827,37.419857"));
                startActivity(i3);
                break;
        }
    }
}
