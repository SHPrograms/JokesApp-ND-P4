package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.util.Pair;
import android.util.Log;
import android.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sh.study.udacitynano.jokeandroidlibrary.JokesActivity;
import com.sh.study.udacitynano.jokejavalibrary.JokesList;


public class MainActivity extends AppCompatActivity {
        //implements AsyncTaskCallListener {
    private static String DEBUG = "SHLog: app:";
    private static String CLASS = "MainActivity:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(DEBUG, CLASS + "onCreate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(DEBUG, CLASS + "onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d(DEBUG, CLASS + "onOptionsItemSelected");
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Log.d(DEBUG, CLASS + "tellJoke");
        JokesList jokes = new JokesList();

/*
        // Testing Java Library
        Toast.makeText(this, "Message from Java Library: " + jokes.getJoke(), Toast.LENGTH_LONG).show();

        // Testing android library
        Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra("joke", jokes.getJoke());
        startActivity(intent);
*/
        Intent intent = new Intent(this, JokesActivity.class);
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, jokes.getJoke()));
        intent.putExtra("joke", jokes.getJoke());
        startActivity(intent);


        // for testing...
/*
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.execute(new Pair<Context, String>(this, "Hey"));
*/

    }

    // version with listener
/*
    @Override
    public void onPostExecuteAT(String string) {
        Log.d(DEBUG, CLASS + "onPostExecuteAT: String: " + string);
        Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra("joke", string);
        startActivity(intent);
    }
*/
}
