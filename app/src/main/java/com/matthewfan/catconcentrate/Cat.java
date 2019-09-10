package com.matthewfan.catconcentrate;


import android.util.Log;

public class Cat {
    private int m_id;
    private double m_spawnProbability;
    private long m_targetGiftsTime;
    private long m_currentGiftsTime;
    private boolean m_spawned = false;


    public Cat(final int ID) {
        m_id = ID;
    }


    public void tick() {
        if(!m_spawned) {
            if(Math.random() >= m_spawnProbability) {
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

        // Start time record
    }


    public void despawn() {
        m_spawned = false;

        // Make associated view hidden

        // End time record and add to m_currentGiftsTime and record
    }


    public int id() {
        return m_id;
    }
}
