package com.codeforiraq.myapp.ui.galleryy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryyViewModel() {
        mText = new MutableLiveData<>();
      //  mText.setValue("عن المبادرة");
    }

    public LiveData<String> getText() {
        return mText;
    }
}