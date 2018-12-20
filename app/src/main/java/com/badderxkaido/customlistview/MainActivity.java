package com.badderxkaido.customlistview;

/*
Created By  Badre Eddine MOUHOUB
            Ingénieur d'Etat, JAVA Software Engineer, ENSAH
            badre.mouhoub@gmail.com
            https://www.linkedin.com/in/bmouhoub/

 */


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> myArr;
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myArr = new ArrayList<>();
        myListView = findViewById(R.id.listView);


        DownloadTask task = new DownloadTask();
        task.execute("https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc");


    }


    // Json Test

    public class DownloadTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpsURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpsURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;

                    data = reader.read();

                }

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

            return null;
        }


        // Parsing Json

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                JSONObject jsonObject = new JSONObject(result);

                String githubItems = jsonObject.getString("items");

//                Log.i("Github Items name", githubItems);


                JSONArray itemsArr = new JSONArray(githubItems);

                for (int i = 0; i < itemsArr.length(); i++) {

                    JSONObject jsonPart = itemsArr.getJSONObject(i);

//                    Log.i(" Github name : ", jsonPart.getString("name"));
//                    Log.i(" Description : ", jsonPart.getString("description"));
//                    Log.i(" Stars : ", jsonPart.getString("stargazers_count"));
//                    Log.i(" Owner Name : ", jsonPart.getJSONObject("owner").getString("login"));
//                    Log.i(" Avatar_url : ", jsonPart.getJSONObject("owner").getString("avatar_url"));
//                    Log.i(" Html_url : ", jsonPart.getString("html_url"));



                    myArr.add(new Item(
                            jsonPart.getString("name"),
                            jsonPart.getString("description"),
                            jsonPart.getJSONObject("owner").getString("login"),
                            jsonPart.getJSONObject("owner").getString("avatar_url"),
                            jsonPart.getString("stargazers_count")
                    ));


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            CustomListAdapter customListAdapter = new CustomListAdapter(
                    getApplicationContext(), R.layout.custom_list_layout, myArr
            );

            myListView.setAdapter(customListAdapter);

        }
    }


}
