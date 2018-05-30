package com.boxstudio.holasoygerman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {


    private static final long SPLASH_SCREEN_DELAY = 6000;

    protected static final int TIMER_RUNTIME = 6000;

    protected boolean nbActive;
    protected ProgressBar nProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


        nProgressBar =(ProgressBar) findViewById(R.id.progressBar);

        final Thread timerThread = new Thread(){

            @Override
            public void run(){

                nbActive = true;

                try{

                    int waited = 10;
                    while(nbActive && (waited < TIMER_RUNTIME)){
                        sleep(10);
                        if(nbActive){
                            waited+=20;
                            updateProgress(waited);
                        }

                    }
                }catch (InterruptedException e){

                }finally {
                    onContinue();
                }
            }
        };
        timerThread.start();
    }


    public void updateProgress(final int timePassed){

        if (null != nProgressBar){

            final int progresss = nProgressBar.getMax()*timePassed /TIMER_RUNTIME;
            nProgressBar.setProgress(progresss);
        }
    }

    public void onContinue(){

        Log.d("","Completo");
    }
}

