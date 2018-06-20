package com.udacity.gradle.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        String joke =  "";

        Intent intent = getIntent();
        if(intent != null){
            joke = intent.getStringExtra(EXTRA_JOKE);
        }

        TextView jokeTv = findViewById(R.id.tv_joke);
        jokeTv.setText(joke);
    }
}
