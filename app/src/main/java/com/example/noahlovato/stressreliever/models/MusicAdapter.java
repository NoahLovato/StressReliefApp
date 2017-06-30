package com.example.noahlovato.stressreliever.models;

import android.os.CountDownTimer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.noahlovato.stressreliever.R;

/**
 * Created by noah.lovato on 6/28/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private static final String TAG = "MusicAdapter";
    ITrack button1 = new Track();
    ITrack button2 = new Track();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }

    private String[] tracks;

    public MusicAdapter(String[] tracks)
    {
        this.tracks = tracks;
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
        final ProgressBar pb = (ProgressBar) cardView.findViewById(R.id.progressBar);
        textView.setText(tracks[position]);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button 1: " + button1.isPlaying());
                Log.d(TAG, "Button 2: " + button2.isPlaying() + "\n");
                Log.d(TAG, "Button id pressed: " + R.id.music_button);
                Log.d(TAG, "Button 1 song: " + button1.getName());
                Log.d(TAG, "Button 2 song: " + button2.getName());

                if(!button1.isPlaying() && !button2.isPlaying())
                {
                    button1 = new Track(imageButton,pb,false,tracks[position]);
                    button1.play();
                }
                else if(button1.isPlaying())
                {
                    button1.stop();
                    if(!button1.getName().equals(tracks[position]))
                    {
                        button2 = new Track(imageButton, pb, false, tracks[position]);
                        button2.play();
                    }
                }
                else if(button2.isPlaying())
                {
                    button2.stop();
                    if(!button2.getName().equals(tracks[position]))
                    {
                        button1 = new Track(imageButton,pb,false,tracks[position]);
                        button1.play();
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
