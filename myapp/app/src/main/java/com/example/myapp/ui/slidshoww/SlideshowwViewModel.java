package com.codeforiraq.myapp.ui.slidshoww;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowwViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowwViewModel() {
        mText = new MutableLiveData<>();
      //  mText.setValue("عن الفريق");
    }

    public LiveData<String> getText() {
        return mText;
    }
}