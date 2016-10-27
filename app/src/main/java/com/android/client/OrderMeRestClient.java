package com.android.client;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 10/23/2016.
 */

public class OrderMeRestClient {

    private final static String API_RootURL = "http://192.168.78.1:8081/OrderMeAPI/rest/";

    public void login() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(API_RootURL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        })

        /*
       StringBuffer chaine = new StringBuffer("");
        try {
            URL url = new URL(API_RootURL + "login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            //JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not successful
           // if(data.getInt("cod") != 200){
            //    return null;
            //}

        } catch (IOException e) {
            // Writing exception to log
            e.printStackTrace();
        }
        return chaine;*/
    }
}
