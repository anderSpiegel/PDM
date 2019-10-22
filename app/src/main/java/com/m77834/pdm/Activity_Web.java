package com.m77834.pdm;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Activity_Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__web);
        HttpTask task = new HttpTask();
        task.execute("user-1", "lab-password");
        try {
            String data = task.get();
            Log.d("WS", data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    class HttpTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL("http://ghelfer.net/la/weather.json");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                ContentValues values = new ContentValues();
                InputStream inputStream = null;
                OutputStream out = con.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                writer.write(getFormData(values));
                writer.flush();
                int statusCode = con.getResponseCode();
                if (statusCode == 200) {
                    inputStream = new BufferedInputStream(con.getInputStream());
                    if (inputStream != null)
                        return convertInputStreamToString(inputStream);
                    else
                        return "Erro nos dados  !";
                } else
                    return "Erro de conexeo!";
            } catch (Exception e) {
                return "Erro: " + e.getLocalizedMessage();

            }
        }

        private String getFormData(ContentValues values) throws UnsupportedEncodingException {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Map.Entry<String, Object> entry : values.valueSet()) {
                if (first)
                    first = false;
                else
                    sb.append("&");

                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
            return sb.toString();
        }

        private String convertInputStreamToString(InputStream inputStream)
                throws IOException {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"), 8);
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine()) != null)
                result += line;

            inputStream.close();
            return result;

        }

    }
}
