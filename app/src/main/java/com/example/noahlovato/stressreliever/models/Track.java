package com.example.noahlovato.stressreliever.models;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.example.noahlovato.stressreliever.MainActivity;
import com.example.noahlovato.stressreliever.R;

/**
 * Created by noah.lovato on 6/30/2017.
 */

public class Track implements ITrack {

    String TAG = "Track";

    ImageButton button;
    SeekBar seekBar;
    boolean playing;
    int id;
    MediaPlayer mediaPlayer;
    Context context;
    int progress;
    CountDownTimer timer;


    public Track()
    {
        button = null;
        seekBar = null;
        playing = false;
        id = 0;
        progress = 0;
    }


    public Track(ImageButton button, SeekBar progressBar,
                 boolean playing, int id, Context context)
    {
        this.button = button;
        this.seekBar = progressBar;
        this.playing = playing;
        this.id = id;
        this.context = context;

        mediaPlayer = MediaPlayer.create(context, id);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });

        final int duration = mediaPlayer.getDuration();
        Log.d(TAG, "Duration of track is: " + duration);
        this.timer = new CountDownTimer(duration,400) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress = 100* mediaPlayer.getCurrentPosition()/duration;
                Log.d(TAG, "Progress of track is: " + progress);
                seekBar.setProgress(progress);
            }

            @Override
            public void onFinish() {

            }
        };

    }

    @Override
    public ImageButton getButton()
    {
        return button;
    }

    public SeekBar getSeekBar() {
        return this.seekBar;
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

    public void setSeekBar(SeekBar seekBar) {
        this.seekBar = seekBar;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setProgress(int progress){
        this.progress = progress;
    }

    @Override
    public int getProgress() {
        return this.progress;
    }

    @Override
    public MediaPlayer getMedia() {
        return mediaPlayer;
    }

    public void play()
    {
        Log.d(TAG,"Play called");
        getButton().setImageResource(R.drawable.ic_pause_black_24dp);
        setPlaying(true);
        mediaPlayer.seekTo(progress);
        mediaPlayer.start();
        timer.start();
    }

    public void stop()
    {
        Log.d(TAG,"Stop called");
        getButton().setImageResource(R.drawable.ic_play_arrow_black_24dp);
        setPlaying(false);
        mediaPlayer.pause();
        progress = mediaPlayer.getCurrentPosition();
        timer.cancel();
    }
}
