package com.example.csci490_lab_04;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyAsyncTask extends android.os.AsyncTask{
    private TextView myText;
    public MyAsyncTask(TextView myText){
        this.myText = myText;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        String url = objects.toString();
        try {
            URL myURL = new URL(url);

            URLConnection connection = myURL.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            return in.readLine();

        }
        catch(MalformedURLException mue){
            System.out.println(mue.getMessage());
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
        return("There was an exception");
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        String text = o.toString();
        myText.setText(text.substring(10,23));
    }
}