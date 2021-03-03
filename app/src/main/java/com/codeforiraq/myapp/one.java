package com.codeforiraq.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codeforiraq.myapp.R;

public class one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        getSupportActionBar().setTitle("أفكار لنوم مولودك");
    }
}