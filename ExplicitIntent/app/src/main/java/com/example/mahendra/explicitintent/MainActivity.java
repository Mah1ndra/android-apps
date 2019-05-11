package com.example.mahendra.explicitintent;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.edit1);
    }

    public void doSomething(View view){
        Intent it = new Intent(this,Second.class);
        it.putExtra("user",e1.getText().toString());
        startActivity(it);
    }
}
