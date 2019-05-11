package com.example.mahendra.asyncinternet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadIMageTask extends AsyncTask<String,Void,Bitmap> {
    Context ctx;
    InputStream is;
    public DownloadIMageTask(Context ct){
        ctx=ct;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        String s = strings[0];
        try {
            URL myUrl = new URL(s);
            HttpURLConnection huc = (HttpURLConnection) myUrl.openConnection();
            huc.setConnectTimeout(20000);
            huc.setReadTimeout(20000);
            huc.setRequestMethod("GET");
            huc.connect();

            is = huc.getInputStream();

            Bitmap myMap = BitmapFactory.decodeStream(is);

            return myMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        MainActivity.img.setImageBitmap(bitmap);
    }
}
