package com.example.camt.lab4;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String jsonUrl = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(jsonUrl, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray actors = response.getJSONArray("actors");
                    ArrayList<Actors> mActorList = new ArrayList<>();
                    ListView mListView = (ListView) findViewById(R.id.list_actor);
                    for (int i = 0; i < actors.length(); i++) {
                        JSONObject actor = actors.getJSONObject(i);

                        Actors item = new Actors();
                        item.setName(actor.getString("name"));
                        item.setDescription(actor.getString("description"));
                        item.setDob(actor.getString("dob"));
                        item.setCountry(actor.getString("country"));
                        item.setHeight(actor.getString("height"));
                        item.setSpouse(actor.getString("spouse"));
                        item.setChildren(actor.getString("children"));
                        item.setImage(actor.getString("image"));

                        mActorList.add(item);

                    }

                    ActorsAdapter mAdapter = new ActorsAdapter(MainActivity.this, R.layout.list_actors, mActorList);
                    mListView.setAdapter(mAdapter);

                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Actors selectedActor = (Actors) adapterView.getItemAtPosition(i);

                            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                            intent.putExtra("actor", selectedActor);
                            startActivity(intent);
                        }
                    });

                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "type wrong name of Json array", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}


