package com.codeforiraq.myapp.ui.gallery;



import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class Util {

    public static void requestPermission(Activity activity, String writeExternalStorage, String readExternalStorage, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{writeExternalStorage,readExternalStorage,permission}, 0);
        }
    }



}