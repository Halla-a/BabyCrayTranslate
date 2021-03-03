package com.codeforiraq.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codeforiraq.myapp.R;

public class Three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        getSupportActionBar().setTitle("فوائد ومضار اللهاية(السكاتة)");
    }
}