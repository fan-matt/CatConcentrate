package com.matthewfan.catconcentrate;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Cat {
    private int m_id;
    private double m_spawnProbability;
    private long m_targetGiftsTime;
    private long m_currentGiftsTime;
    private boolean m_spawned = false;
    private ImageView m_image;


    public Cat(final int ID , final double SPAWN_PROBABILITY , final long CURRENT_GIFTS_TIME ,
               final ImageView IMAGE) {
        m_id = ID;
        m_spawnProbability = SPAWN_PROBABILITY;
        m_targetGiftsTime = CURRENT_GIFTS_TIME;
        m_image = IMAGE;
    }


    public void tick() {
        if(!m_spawned) {
            if(Math.random() <= m_spawnProbability) {
                m_spawn();
            }
        }

        // Flip flop images

        Log.d("Cat " + String.valueOf(m_id), "I'm alive!");
    }


    private void m_spawn() {
        // Spawn cat
        m_spawned = true;

        // Make associated view visible
        m_image.setVisibility(View.VISIBLE);

        // Start time record
    }


    public void despawn() {
        m_spawned = false;

        // Make associated view hidden
        m_image.setVisibility(View.GONE);

        // End time record and add to m_currentGiftsTime and record
    }


    public int id() {
        return m_id;
    }
}
