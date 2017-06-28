package com.example.noahlovato.stressreliever.models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noahlovato.stressreliever.ImageAdapter;
import com.example.noahlovato.stressreliever.R;

/**
 * Created by noah.lovato on 6/28/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private static final String TAG = "MusicAdapter";

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
        textView.setText(tracks[position]);
    }

    @Override
    public int getItemCount() {
        return tracks.length;
    }
}
