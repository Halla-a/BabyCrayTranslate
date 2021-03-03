package com.codeforiraq.myapp.ui.gallery;

import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codeforiraq.myapp.R;

public class GalleryViewModel extends ViewModel {
        Button m;
    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
       // mText.setValue("This is gallery fragment");
    }


    public LiveData<String> getText() {
        return mText;
    }

    public void Class() {

    }

}