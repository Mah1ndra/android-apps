package com.example.mahendra.debugapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.edit1);
        e2 = (EditText) findViewById(R.id.edit2);
        b1 = (Button) findViewById(R.id.add);
        t1 = (TextView) findViewById(R.id.result);
    }

    public void Add(View view) {
        Log.i("MainActivity","Executed 1");
        int n1 = Integer.parseInt(e1.getText().toString());
        Log.i("MainActivity","Executed 2");
        int n2 = Integer.parseInt(e2.getText().toString());
        Log.i("MainActivity","Executed 3");
        int sum = n1+n2;
        Log.i("MainActivity","Executed 4");
        t1.setText(" "+sum);
        Log.i("MainActivity","Executed 5");
    }
}
