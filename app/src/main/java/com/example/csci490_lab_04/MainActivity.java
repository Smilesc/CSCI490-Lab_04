package com.example.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("url string" , urlConnect("https://jsonplaceholder.typicode.com/users"));
    }

    public String urlConnect(String url){
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
}
