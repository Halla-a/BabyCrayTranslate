package com.codeforiraq.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.examle.myapp.R;
import com.codeforiraq.myapp.ui.gallery.GalleryFragment;
import com.codeforiraq.myapp.ui.gallery.GalleryViewModel;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button b;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
          b =(Button) findViewById(R.id.button);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_galleryy, R.id.nav_slideshow, R.id.nav_slideshoww)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    public void onclick1 (View v){
        Intent b = new Intent(this,GalleryViewModel.class);
        startActivity(b);

    }

    public void onclick11 (View v){
        Intent one = new Intent(this, com.codeforiraq.myapp.one.class);
        startActivity(one);

    }
    public void onclick12 (View v){
        Intent one = new Intent(this, com.codeforiraq.myapp.Two.class);
        startActivity(one);

    }
    public void onclick13 (View v){
        Intent one = new Intent(this, com.codeforiraq.myapp.Three.class);
        startActivity(one);

    }
    public void onclick14 (View v){
        Intent one = new Intent(this, com.codeforiraq.myapp.four.class);
        startActivity(one);

    }

    public void onclick15 (View v){
        Intent one = new Intent(this, com.codeforiraq.myapp.Five.class);
        startActivity(one);

    }
    public void onclick16 (View v){
        Intent one = new Intent(this, com.codeforiraq.myapp.six.class);
        startActivity(one);

    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainn, menu);
        return true;
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}