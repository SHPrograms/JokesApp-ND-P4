package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
//import android.support.v4.util.Pair;
import android.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sh.study.udacitynano.jokeandroidlibrary.JokesActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static String DEBUG = "SHLog: app:";
    private static String CLASS = "EndpointsAsyncTask:";

    private static MyApi myApiService = null;
    private Context context;

//    AsyncTaskCallListener listener;

/*
    public EndpointsAsyncTask(Context context, AsyncTaskCallListener listener) {
        this.listener = listener;
        this.context = context;
        Log.d(DEBUG, CLASS + "constructor + listener");
    }
*/

    public EndpointsAsyncTask(Context context) {
//        this.listener = null;
        this.context = context;
        Log.d(DEBUG, CLASS + "constructor");
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {

        if (myApiService == null) {  // Only do this once
            Log.d(DEBUG, CLASS + "doInBackground - once.");

            // Locally -> I can't test it because
            // https://discussions.udacity.com/t/gradle-task-and-localhost-8080-error/558065

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            // end options for devappserver

            // TODO: change to locally before submit
/*
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokesapp-nd-p4.appspot.com/_ah/api/");
*/

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        Log.d(DEBUG, CLASS + "doInBackground. name: " + name);
        try {
            return myApiService.tellJoke(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(DEBUG, CLASS + "onPostExecute. result send to MainActivity.");
        Intent intent = new Intent(context, JokesActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);

//            listener.onPostExecuteAT(result);
    }
}