package com.example.noahlovato.stressreliever.models;

import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/**
 * Created by noah.lovato on 6/30/2017.
 */

public interface ITrack {

    public ImageButton getButton();
    public boolean isPlaying();
    public void setPlaying(boolean playing);
    public void setButton(ImageButton button);
    public void setId(int id);
    public int getId();
    public int getProgress();
    public SeekBar getSeekBar();
    public void setSeekBar(SeekBar progress);
    public MediaPlayer getMedia();
    public void play();
    public void stop();

}
