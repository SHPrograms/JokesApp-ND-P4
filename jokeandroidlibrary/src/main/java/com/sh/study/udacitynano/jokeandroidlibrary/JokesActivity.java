package com.sh.study.udacitynano.jokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        TextView textView = findViewById(R.id.joke_tv);
        if (getIntent().hasExtra("joke")){
            textView.setText(getIntent().getStringExtra("joke"));
        }

    }
}
