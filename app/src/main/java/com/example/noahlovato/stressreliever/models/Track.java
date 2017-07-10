package com.example.noahlovato.stressreliever.models;

import android.os.CountDownTimer;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.example.noahlovato.stressreliever.R;

/**
 * Created by noah.lovato on 6/30/2017.
 */

public class Track implements ITrack {

    ImageButton button;
    ProgressBar progressBar;
    boolean playing;
    int id;
    CountDownTimer timer;

    public Track()
    {
        button = null;
        progressBar = null;
        playing = false;
        timer = null;
        id = 0;
    }


    public Track(ImageButton button, ProgressBar progressBar, boolean playing, int id)
    {
        this.button = button;
        this.progressBar = progressBar;
        this.playing = playing;
        this.id = id;

        this.timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                getProgressBar().incrementProgressBy(5);
            }

            @Override
            public void onFinish()
            {
                stop();
            }
        };
    }

    @Override
    public ImageButton getButton()
    {
        return button;
    }

    @Override
    public ProgressBar getProgressBar() {
        return this.progressBar;
    }

    @Override
    public boolean isPlaying()
    {
        return playing;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setPlaying(boolean playing)
    {
        this.playing = playing;
    }

    @Override
    public void setButton(ImageButton button)
    {
        this.button = button;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void play()
    {
        getButton().setImageResource(R.drawable.ic_pause_black_24dp);
        setPlaying(true);
        timer.start();
    }

    public void stop()
    {
        timer.cancel();
        getProgressBar().incrementProgressBy(-100);
        getButton().setImageResource(R.drawable.ic_play_arrow_black_24dp);
        setPlaying(false);
    }
}
