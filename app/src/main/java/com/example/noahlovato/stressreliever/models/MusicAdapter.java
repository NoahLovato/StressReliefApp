package com.example.noahlovato.stressreliever.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.noahlovato.stressreliever.ImageAdapter;
import com.example.noahlovato.stressreliever.R;

/**
 * Created by noah.lovato on 6/28/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private static final String TAG = "MusicAdapter";
    boolean isPlaying = false;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView textView = (TextView) cardView.findViewById(R.id.song_title);
        final ImageButton imageButton = (ImageButton) cardView.findViewById(R.id.music_button);
        textView.setText(tracks[position]);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPlaying) {
                    isPlaying = true;
                    imageButton.setImageResource(R.drawable.ic_pause_black_24dp);
                }
                else{
                    isPlaying = false;
                    imageButton.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tracks.length;
    }
}