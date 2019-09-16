package com.matthewfan.catconcentrate;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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


    private Cat[] m_cats = new Cat[2];
    private double[] m_catSpawnProbabilities = {1 , 1};
    private long[] m_catTargetGiftsTime = {50 , 50};
    @SuppressWarnings("FieldCanBeLocal")
    private ImageView[] m_catBackgrounds;
    private Drawable[][] m_animationFrames = new Drawable[2][];
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

        for(ImageView imageView : m_catBackgrounds) {
            imageView.setVisibility(View.GONE);
        }

        Drawable[] cat1AnimationFrames =
                {getDrawable(R.drawable.cat1_frame1) , getDrawable(R.drawable.cat1_frame2)};

        Drawable[] cat2AnimationFrames =
                {getDrawable(R.drawable.cat2_frame1) , getDrawable(R.drawable.cat2_scroll2)};

        m_animationFrames[0] = cat1AnimationFrames;
        m_animationFrames[1] = cat2AnimationFrames;


        for(int i = 0; i < m_cats.length; i ++) {
            m_cats[i] = new Cat(i , m_catSpawnProbabilities[i] , m_catTargetGiftsTime[i] ,
                    m_catBackgrounds[i] , m_animationFrames[i]);
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

        assert powerManager != null;
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
