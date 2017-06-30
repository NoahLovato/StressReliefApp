package com.example.noahlovato.stressreliever.models;

import android.widget.ImageButton;
import android.widget.ProgressBar;

/**
 * Created by noah.lovato on 6/30/2017.
 */

public interface ITrack {

    public ImageButton getButton();
    public boolean isPlaying();
    public void setPlaying(boolean playing);
    public void setButton(ImageButton button);
    public void setName(String name);
    public String getName();
    public ProgressBar getProgressBar();
    public void setProgressBar(ProgressBar progress);
    public void play();
    public void stop();

}
