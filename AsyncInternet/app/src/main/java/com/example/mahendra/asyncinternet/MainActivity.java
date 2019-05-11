package com.example.mahendra.asyncinternet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b,bt;
    DownloadIMageTask dit;
    ConnectToInternet c;
    static TextView tv;
    static ImageView img;

    ConnectivityManager myConnManager;
    NetworkInfo ni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b =(Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.result);
        bt = (Button)findViewById(R.id.imageb);
        img = (ImageView)findViewById(R.id.imageView);

        myConnManager =(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        ni = myConnManager.getActiveNetworkInfo();
        myConnManager =(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        ni = myConnManager.getActiveNetworkInfo();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ni!=null&&ni.isConnected()) {
                    c = new ConnectToInternet(MainActivity.this);
                    c.execute("http://www.google.com");
                }else{
                    Toast.makeText(MainActivity.this,"Internet Not Connected",Toast.LENGTH_SHORT).show();
                }


            }
        });



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ni!=null && ni.isConnected()){
                    dit = new DownloadIMageTask(MainActivity.this);
                    dit.execute("https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/150px-Google_%22G%22_Logo.svg.png");
                }else {
                    Toast.makeText(MainActivity.this,"Internet Not Connected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}

