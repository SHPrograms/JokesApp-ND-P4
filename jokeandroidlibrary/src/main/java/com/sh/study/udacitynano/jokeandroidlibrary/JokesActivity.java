package com.sh.study.udacitynano.jokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    private static String DEBUG = "SHLog: androidLib:";
    private static String CLASS = "JokesActivity:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Log.d(DEBUG, CLASS + "onCreate");
        TextView textView = findViewById(R.id.joke_tv);
        if (getIntent().hasExtra("joke")){
            textView.setText(getIntent().getStringExtra("joke"));
        }

    }
}
