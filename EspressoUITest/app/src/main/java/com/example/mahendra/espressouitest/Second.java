package com.example.mahendra.espressouitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t1 = (TextView)findViewById(R.id.textView);

        Bundle b1 = getIntent().getExtras();
        String s1 = b1.getString("key1").toString();
        t1.setText("Welcome! "+s1);
    }
}
