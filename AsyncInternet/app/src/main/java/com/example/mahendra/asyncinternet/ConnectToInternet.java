package com.example.mahendra.asyncinternet;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectToInternet extends AsyncTask<String,Void,String> {
    Context ctx;
    InputStream in;
    public ConnectToInternet(Context ct){
        ctx=ct;
    }

    @Override
    protected String doInBackground(String... strings) {
        String s = strings[0];
        try {
            URL myUrl = new URL(s);
            HttpURLConnection huc = (HttpURLConnection) myUrl.openConnection();
            huc.setReadTimeout(10000);
            huc.setConnectTimeout(20000);
            huc.setRequestMethod("GET");
            huc.connect();

            in = huc.getInputStream();

            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = "";

            while ((line = buf.readLine())!=null){
                sb.append(line+" \n");
            }

            buf.close();
            in.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    protected void onPostExecute(String s) {
    MainActivity.tv.setText(s);
    }
}
