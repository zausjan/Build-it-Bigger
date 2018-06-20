package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import com.udacity.gradle.androidlib.DisplayJoke;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.udacity.gradle.androidlib.DisplayJoke.EXTRA_JOKE;


public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi jokeApi;
    private Context context;

    public EndpointsAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(jokeApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            jokeApi = builder.build();
        }

        try {
            return jokeApi.putJoke(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Start Display Actvity
        Intent intent = new Intent(context, DisplayJoke.class);
        intent.putExtra(EXTRA_JOKE, result);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}