package com.matthewfan.catconcentrate;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private Handler m_timerHandler = new Handler();
    private Runnable m_timerRunnable = new Runnable() {
        @Override
        public void run() {
            m_tick();
            m_timerHandler.postDelayed(this , 1000);
        }
    };


    private Cat[] m_cats = new Cat[4];
    private double[] m_catSpawnProbabilities = {.2 , .5 , .7 , 1};
    private long[] m_catTargetGiftsTime = {50 , 50 , 50 , 50};
    private ImageView[] m_catBackgrounds;

    private boolean m_isTicking = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_catBackgrounds = new ImageView[] {
            findViewById(R.id.cat1ImageView) ,
            findViewById(R.id.cat2ImageView) ,
            findViewById(R.id.cat3ImageView) ,
            findViewById(R.id.cat4ImageView) ,
        };


        for(int i = 0; i < 4; i ++) {
            m_cats[i] = new Cat(i , m_catSpawnProbabilities[i] , m_catTargetGiftsTime[i] ,
                    m_catBackgrounds[i]);
        }

        for(ImageView imageView : m_catBackgrounds) {
            imageView.setVisibility(View.GONE);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(!m_isTicking) {
            // Start ticks
            m_timerHandler.post(m_timerRunnable);
            m_isTicking = true;
        }

        Log.d("Timer", "resume");
    }


    @Override
    protected void onPause() {
        super.onPause();

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);

        if(powerManager.isInteractive()) {
            m_timerHandler.removeCallbacks(m_timerRunnable);
            m_isTicking = false;

            // Despawn cats
            for(Cat cat : m_cats) {
                cat.despawn();
            }

            Log.d("Timer", "pause");
        }
    }



    public void openGiftsActivity(View view) {
        Intent launchGiftsIntent = new Intent(this , GiftsActivity.class);
        startActivity(launchGiftsIntent);
    }


    private void m_tick() {
        Log.d("Timer", "tick");
        for(Cat cat : m_cats) {
            cat.tick();
        }
    }
}
