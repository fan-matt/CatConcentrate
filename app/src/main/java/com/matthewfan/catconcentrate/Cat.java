package com.matthewfan.catconcentrate;


import android.graphics.drawable.Drawable;
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
    private Drawable[] m_animationFrames;
    private int m_currentAnimationFrameIndex = 0;


    public Cat(final int ID , final double SPAWN_PROBABILITY , final long CURRENT_GIFTS_TIME ,
               final ImageView IMAGE , final Drawable[] ANIMATION_FRAMES) {
        m_id = ID;
        m_spawnProbability = SPAWN_PROBABILITY;
        m_targetGiftsTime = CURRENT_GIFTS_TIME;
        m_image = IMAGE;
        m_animationFrames = ANIMATION_FRAMES;
    }


    public void tick() {
        if(!m_spawned) {
            if(Math.random() <= m_spawnProbability) {
                m_spawn();
            }
        }

        // Animate the cat
        m_currentAnimationFrameIndex ++;

        if(m_currentAnimationFrameIndex == m_animationFrames.length) {
            m_currentAnimationFrameIndex = 0;
        }

        m_image.setImageDrawable(m_animationFrames[m_currentAnimationFrameIndex]);
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
