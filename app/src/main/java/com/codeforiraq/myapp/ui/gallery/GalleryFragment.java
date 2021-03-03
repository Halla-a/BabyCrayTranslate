package com.codeforiraq.myapp.ui.gallery;

import android.Manifest;
import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.codeforiraq.myapp.R;


public class GalleryFragment extends Fragment {
//
private static final int REQUEST_RECORD_AUDIO = 0;
    private static final String AUDIO_FILE_PATH =
            Environment.getExternalStorageDirectory().getPath() + "/recorded_audio.wav";
  //
  private int bufferSize = 0;
    private String resul;
 private float result;
    private GalleryViewModel galleryViewModel;
    private boolean isRecording = false;
    private Chronometer timer;
    private Button rec;
    private Button btn2;
    private String recordFile;
    private String recordPermission = Manifest.permission.RECORD_AUDIO;
    private  int PERMISSION_CODE = 21;
    private MediaRecorder mediaRecorder;
    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

                      galleryViewModel =
                              ViewModelProviders.of(this).get(GalleryViewModel.class);

                      View root = inflater.inflate(R.layout.fragment_gallery, container, false);

                      final TextView labelrec = root.findViewById(R.id.text_gallery);
                      rec = root.findViewById(R.id.voice1);
                      timer = root.findViewById(R.id.record_timer);
                      btn2=(Button)root.findViewById(R.id.button2);
        //Util.requestPermission(getActivity(), Manifest.permission.RECORD_AUDIO);
      //  Util.requestPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);



                      
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
try{


    } catch (Exception e) {
        e.getMessage();
    }

        //labelrec.setText();
          }
});

                      rec.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View view) {



                          }

                      });
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                labelrec.setText(s);
            }
        });
        return root;
    }


    private void compir() {




    }



}