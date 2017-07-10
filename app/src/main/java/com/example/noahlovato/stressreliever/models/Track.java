package com.example.noahlovato.stressreliever.models;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
    MediaPlayer mediaPlayer;
    Context context;

    public Track()
    {
        button = null;
        progressBar = null;
        playing = false;
        id = 0;
    }


    public Track(ImageButton button, ProgressBar progressBar,
                 boolean playing, int id, Context context)
    {
        this.button = button;
        this.progressBar = progressBar;
        this.playing = playing;
        this.id = id;

        mediaPlayer = MediaPlayer.create(context, id);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

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
        mediaPlayer.start();
    }

    public void stop()
    {
        getButton().setImageResource(R.drawable.ic_play_arrow_black_24dp);
        setPlaying(false);
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
