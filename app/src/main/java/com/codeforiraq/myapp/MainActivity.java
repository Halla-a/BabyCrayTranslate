package com.codeforiraq.myapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.codeforiraq.myapp.R;

import com.codeforiraq.myapp.ui.gallery.Util;
import com.codeforiraq.myapp.ui.galleryy.GalleryyFragment;
import com.codeforiraq.myapp.ui.home.HomeFragment;
import com.codeforiraq.myapp.ui.slideshow.SlideshowFragment;
import com.codeforiraq.myapp.ui.slidshoww.SlideshowwFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle drawerToggle;
    private boolean startup=true;
    DrawerLayout drawerLayout;
    private int bufferSize = 0;
    NavigationView navigation;
    private AppBarConfiguration mAppBarConfiguration;
    private static final int REQUEST_RECORD_AUDIO = 0;
    private static final String AUDIO_FILE_PATH =
            Environment.getExternalStorageDirectory().getPath() + "/recorded_audio.wav";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      // com.example.myapp.ui.gallery.Util.requestPermission(this, READ_EXTERNAL_STORAGE, RECORD_AUDIO);
       // Uti.requestPermission(this, WRITE_EXTERNAL_STORAGE);
       // Uti.requestPermission(this, READ_EXTERNAL_STORAGE);
        Util.requestPermission(this,WRITE_EXTERNAL_STORAGE ,READ_EXTERNAL_STORAGE, RECORD_AUDIO);

        File folder = new File(Environment.getExternalStorageDirectory() + "/babecry");

        if (!folder.exists()) {

            //folder /SoundRecorder doesn't exist, create the folder
            folder.mkdir();
        }
        initInstances();
    }



    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
        private void initInstances() {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.setDrawerListener(drawerToggle);

            navigation = (NavigationView) findViewById(R.id.nav_view);
            navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    int id = menuItem.getItemId();

                        if (startup) {
                            ((FrameLayout) findViewById(R.id.nav_host_fragment)).removeAllViews();

                        }

                    if(id== R.id.nav_home){
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        getSupportActionBar().setTitle("الرئيسية");
                        HomeFragment gf = new HomeFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, gf);
                        transaction.commit();


                    }
                    if(id== R.id.nav_gallery){
                        //Do some thing here
                        // add navigation drawer item onclick method here

                        /**/
                        getSupportActionBar().setTitle("تسجيل الصوت");
                        Intent i=new Intent(MainActivity.this,result.class);
                        startActivity(i);

                    }
                    if(id== R.id.nav_galleryy){
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        getSupportActionBar().setTitle("عن المبادرة");
                        GalleryyFragment ge = new GalleryyFragment();
                        FragmentTransaction transactionn = getSupportFragmentManager().beginTransaction();
                        transactionn.replace(R.id.nav_host_fragment, ge);
                        transactionn.commit();
                    }
                    if(id== R.id.nav_slideshow) {
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        getSupportActionBar().setTitle("نصائح عامة");
                        SlideshowFragment sl = new SlideshowFragment();
                        FragmentTransaction transactionnn = getSupportFragmentManager().beginTransaction();
                        transactionnn.replace(R.id.nav_host_fragment, sl);
                        transactionnn.commit();
                    }
                    if(id== R.id.nav_slideshoww) {
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        getSupportActionBar().setTitle("عن التطبيق");
                        SlideshowwFragment sll = new SlideshowwFragment();
                        FragmentTransaction transactionnnn = getSupportFragmentManager().beginTransaction();
                        transactionnnn.replace(R.id.nav_host_fragment, sll);
                        transactionnnn.commit();
                    }


                    drawerLayout.closeDrawer(GravityCompat.START);
                  //  drawerLayout.closeDrawers();
                    return false;
                }
            });

        }

        @Override
        public void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
            drawerToggle.syncState();
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            drawerToggle.onConfigurationChanged(newConfig);
        }

    /* @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.navigation_view_items, menu);
         return true;
     }
 */
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (drawerToggle.onOptionsItemSelected(item))
                return true;

            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.string.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    /*@Override
    public void onStart(){
        super.onStart();
        try{

            byte[] buffer = null;
            InputStream fIn = getBaseContext().getResources()
                    .openRawResource(R.raw.rt);
            InputStream fInn = getBaseContext().getResources()
                    .openRawResource(R.raw.heh);
            InputStream fInnn = getBaseContext().getResources()
                    .openRawResource(R.raw.owh);
            int size = 0;
            System.out.println("<<<<<<<SIZE>>>>>>>>>>>>>>>>>>>>" + fIn);
            try {
                size = fIn.available();
                size = fInn.available();
                size = fInnn.available();

                System.out
                        .println("<<<<<<<SIZE>>>>>>>>>>>>>>>>>>>>" + size);
                buffer = new byte[size];
                fIn.read(buffer);
                fIn.close();
                fInn.read(buffer);
                fInn.close();
                fInnn.read(buffer);
                fInnn.close();
            } catch (IOException e) {
                e.getMessage();

            }
            String path = Environment.getExternalStorageDirectory().getPath() + "/babecry/";

            String filename = "rt" + ".wav";
            String filenamee = "heh" + ".wav";
            String filenameee = "owh" + ".wav";

            boolean exists = (new File(path)).exists();
            if (!exists) {
                System.out
                        .println("<<<<<<<FALSE SO INSIDE THE CONDITION>>>>>>>>>>>>>>>>>>>>");
                new File(path).mkdirs();
            }

            FileOutputStream save,savee,saveee;
            try {
                save = new FileOutputStream(path + filename);
                savee = new FileOutputStream(path + filenamee);
                saveee = new FileOutputStream(path + filenameee);
                System.out
                        .println("<<<<<<<SAVE>>>>>>>>>>>>>>>>>>>>" + save);
                save.write(buffer);
                save.flush();
                save.close();
                savee.write(buffer);
                savee.flush();
                savee.close();
                saveee.write(buffer);
                saveee.flush();
                saveee.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://" + path + filename)));

            File k = new File(path, filename);
            System.out.println("<<<<<<<SAVE>>>>>>>>>>>>>>>>>>>>" + k);



        }
        catch(Exception e){

        }
    }*/
    public void onclick11(View view){
            Intent i=new Intent(this,one.class);
            startActivity(i);
    }
    public void onclick12(View view){
        Intent i=new Intent(this,Two.class);
        startActivity(i);
    }
    public void onclick13(View view){
        Intent i=new Intent(this,Three.class);
        startActivity(i);
    }
    public void onclick14(View view){
        Intent i=new Intent(this,four.class);
        startActivity(i);
    }
    public void onclick15(View view){
        Intent i=new Intent(this,Five.class);
        startActivity(i);
    }
    public void onclick16(View view){
        Intent i=new Intent(this,six.class);
        startActivity(i);
    }
}