package com.example.noahlovato.stressreliever.models;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.noahlovato.stressreliever.R;

/**
 * Created by noah.lovato on 6/28/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private static final String TAG = "MusicAdapter";
    Context context;
    ITrack track1 = new Track();
    ITrack track2 = new Track();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }

    private int[] tracks;

    public MusicAdapter(int[] tracks, Context context)
    {
        this.tracks = tracks;
        this.context = context;
    }

    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_track,parent,false);
        return new MusicAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        TextView textView = (TextView) cardView.findViewById(R.id.song_title);
        final ImageButton imageButton = (ImageButton) cardView.findViewById(R.id.music_button);
        final SeekBar pb = (SeekBar) cardView.findViewById(R.id.seekBar);
        textView.setText(tracks[position]);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button 1: " + track1.isPlaying());
                Log.d(TAG, "Button 2: " + track2.isPlaying() + "\n");
                Log.d(TAG, "Button 1 song: " + track1.getId());
                Log.d(TAG, "Button 2 song: " + track2.getId());

                if(!track1.isPlaying() && !track2.isPlaying())
                {
                            Log.d(TAG, "Playing track 1 from start");
                            track1 = new Track(imageButton, pb, false, tracks[position], context);
                            track1.play();
                }
                else if(track1.isPlaying())
                {
                    Log.d(TAG, "Stopping track 1");
                    track1.stop();
                    if(!(track1.getId() == tracks[position]))
                    {
                        Log.d(TAG, "Resetting track 1");
                        track1.getSeekBar().setProgress(0);
                        track1.getMedia().release();
                        Log.d(TAG, "Playing track 2 from start");
                        track2 = new Track(imageButton, pb, false, tracks[position], context);
                        track2.play();
                    }
                }
                else if(track2.isPlaying())
                {
                    Log.d(TAG, "Stopping track 2");
                    track2.stop();
                    if(!(track2.getId() == tracks[position]))
                    {
                        Log.d(TAG, "Resetting track 2");
                        track2.getSeekBar().setProgress(0);
                        track2.getMedia().release();
                        Log.d(TAG, "Playing track 1 from start");
                        track1 = new Track(imageButton,pb,false,tracks[position], context);
                        track1.play();
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return tracks.length;
    }
}
