package com.codeforiraq.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import com.codeforiraq.myapp.R;
import com.codeforiraq.myapp.model.AudioChannel;
import com.codeforiraq.myapp.model.AudioSampleRate;
import com.codeforiraq.myapp.model.AudioSource;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class result extends AppCompatActivity {
    TextView resu,t47,t48,t50,t51,t52,t49;
    private static final int REQUEST_RECORD_AUDIO = 0;
    private static final String AUDIO_FILE_PATH =
            Environment.getExternalStorageDirectory().getPath() + "/recorded_audio.wav";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setTitle(" سبب البكاء ");
        resu=(TextView)findViewById(R.id.resu);

        t48=(TextView)findViewById(R.id.textView48);
        t49=(TextView)findViewById(R.id.textView49);
        t50=(TextView)findViewById(R.id.textView50);
        t51=(TextView)findViewById(R.id.textView51);
        t52=(TextView)findViewById(R.id.textView52);
////

        try{

            byte[] buffer = null;
            byte[] buffer1 = null;
            byte[] buffer2 = null;
            byte[] buffer3 = null;
            byte[] buffer4 = null;
            InputStream fIn = getBaseContext().getResources()
                    .openRawResource(R.raw.eair);
            InputStream fInn = getBaseContext().getResources()
                    .openRawResource(R.raw.heh);
            InputStream fInnn = getBaseContext().getResources()
                    .openRawResource(R.raw.neh);
            InputStream fInnnn = getBaseContext().getResources()
                    .openRawResource(R.raw.owh);
            InputStream fInnnnn = getBaseContext().getResources()
                    .openRawResource(R.raw.eh);
            int size = 0;
            int sizee = 0;
            int sizeee = 0;
            int sizeeee = 0;
            int sizeeeee = 0;


            System.out.println("<<<<<<<SIZE>>>>>>>>>>>>>>>>>>>>" + fIn);
            try {
                size = fIn.available();
                sizee = fInn.available();
                sizeee = fInnn.available();
                sizeeee = fInnnn.available();
                sizeeeee = fInnnnn.available();


                System.out.println("<<<<<<<SIZE>>>>>>>>>>>>>>>>>>>>" + size+sizee);
                buffer = new byte[size];
                buffer1 = new byte[sizee];
                buffer2 = new byte[sizeee];
                buffer3 = new byte[sizeeee];
                buffer4 = new byte[sizeeeee];
                fIn.read(buffer);
                fIn.close();
                fInn.read(buffer1);
                fInn.close();
                fInnn.read(buffer2);
                fInnn.close();
                fInnnn.read(buffer3);
                fInnnn.close();
                fInnnnn.read(buffer4);
                fInnnnn.close();
            } catch (IOException e) {
                e.getMessage();

            }
            String path = Environment.getExternalStorageDirectory().getPath() + "/babecry/";

            String filename = "eair" + ".wav";
            String filenamee = "heh" + ".wav";
            String filenameee = "neh" + ".wav";
            String filenameeee = "owh" + ".wav";
            String filenameeeee = "eh" + ".wav";

            boolean exists = (new File(path)).exists();
            if (!exists) {
                System.out
                        .println("<<<<<<<FALSE SO INSIDE THE CONDITION>>>>>>>>>>>>>>>>>>>>");
                new File(path).mkdirs();
            }

            FileOutputStream save,savee,saveee,saveeee,saveeeee;
            try {
                save = new FileOutputStream(path + filename);
                savee = new FileOutputStream(path + filenamee);
                saveee = new FileOutputStream(path + filenameee);
                saveeee = new FileOutputStream(path + filenameeee);
                saveeeee = new FileOutputStream(path + filenameeeee);
                System.out
                        .println("<<<<<<<SAVE>>>>>>>>>>>>>>>>>>>>" + save);
                save.write(buffer);
                save.flush();
                save.close();
                savee.write(buffer1);
                savee.flush();
                savee.close();
                saveee.write(buffer2);
                saveee.flush();
                saveee.close();
                saveeee.write(buffer3);
                saveeee.flush();
                saveeee.close();
                saveeeee.write(buffer4);
                saveeeee.flush();
                saveeeee.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }
          /*  sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://" + path + filename)));

            File k = new File(path, filename);
            System.out.println("<<<<<<<SAVE>>>>>>>>>>>>>>>>>>>>" + k);
*/


        }
        catch(Exception e){

        }




        //////
        AndroidAudioRecorder.with(result.this)
                // Required
                .setFilePath(AUDIO_FILE_PATH)
                .setColor(ContextCompat.getColor(result.this, R.color.recorder_b))
                .setRequestCode(REQUEST_RECORD_AUDIO)

                // Optional
                .setSource(AudioSource.MIC)
                .setChannel(AudioChannel.STEREO)
                .setSampleRate(AudioSampleRate.HZ_48000)
                .setAutoStart(false)
                .setKeepDisplayOn(true)

                // Start recording
                .record();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_RECORD_AUDIO) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(result.this, "Audio recorded successfully!", Toast.LENGTH_SHORT).show();
                compir();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(result.this, "Audio was not recorded", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void compir() {




            final String rootPath = Environment.getExternalStorageDirectory().getPath() + "/babecry/";
            final String rootPathh = Environment.getExternalStorageDirectory().getPath() ;
            String p0 = rootPathh + "/recorded_audio.wav";
           
            String p1 = rootPath + "heh.wav";
            String p2 = rootPath + "owh.wav";
            String p3 = rootPath + "eh.wav";
            String p4 = rootPath + "eair.wav";
            String p5 = rootPath + "neh.wav";

            Wave w0 = new Wave(p0);
            Wave w1 = new Wave(p1);
            Wave w2 = new Wave(p2);
            Wave w3 = new Wave(p3);
            Wave w4 = new Wave(p4);
            Wave w5 = new Wave(p5);


            //----------------------------------------------//
           FingerprintSimilarity fingerprintSimilarity = w0.getFingerprintSimilarity(w1);
            float score = fingerprintSimilarity.getScore();
            float similarity = fingerprintSimilarity.getSimilarity();
        float msimilarity = fingerprintSimilarity.getMostSimilarFramePosition();
             //----------------------------------------------//
            FingerprintSimilarity fingerprintSimilarity1 = w0.getFingerprintSimilarity(w2);
            float score1 = fingerprintSimilarity1.getScore();
            float similarity1 = fingerprintSimilarity1.getSimilarity();
        float msimilarity1 = fingerprintSimilarity1.getMostSimilarFramePosition();
            //----------------------------------------------//
            FingerprintSimilarity fingerprintSimilarity2 = w0.getFingerprintSimilarity(w3);
            float score2 = fingerprintSimilarity2.getScore();
            float similarity2 = fingerprintSimilarity2.getSimilarity();
        float msimilarity2 = fingerprintSimilarity2.getMostSimilarFramePosition();

            //----------------------------------------------//
            FingerprintSimilarity fingerprintSimilarity3 = w0.getFingerprintSimilarity(w4);
            float score3 = fingerprintSimilarity3.getScore();
            float similarity3 = fingerprintSimilarity3.getSimilarity();
        float msimilarity3 = fingerprintSimilarity3.getMostSimilarFramePosition();
            //----------------------------------------------//
            FingerprintSimilarity fingerprintSimilarity4 = w0.getFingerprintSimilarity(w5);
            float score4 = fingerprintSimilarity4.getScore();
            float similarity4 = fingerprintSimilarity4.getSimilarity();
        float msimilarity4 = fingerprintSimilarity4.getMostSimilarFramePosition();

            //----------------------------------------------//


        if(similarity>=0.02111111){
            resu.setText("عدم الاراحه : " +

                    "طفلك منزعج ," +
                    "قم بتغير الحفاضة(الدايبي).");

        }
        else if(similarity1>=0.02111111){
            resu.setText("النعاس : " +

                    "طفلك يحتاج الى ان يخلد للنوم" +
                    "");

        }
        else if(similarity2>=0.02111111){
            resu.setText("التجشؤ : " +

                    "طفلك يحتاج أن يتجشئ." +
                    " ضعيه بوضعية مناسبة ليرتاح.");
        }
        else if(similarity3>=0.02111111){
            resu.setText("يملك الغازات : " +

                    "طفلك منزعج من الغارات التي لديه," +
                    " ضعيه بوضعية مناسبة ليرتاح اكثر.");

        }
        else if(similarity4>=0.02111111){
            resu.setText("الجوع : " +

                    "طفلك يحتاج الى الحليب" +
                    " فهو يشعر بالجوع  " +
                    "عند بكاءه بهذه الطريقة.");
        }
        else {
            Toast.makeText(result.this, "لاتوجد حالات متطابقة", Toast.LENGTH_SHORT).show();
        }









    }
}