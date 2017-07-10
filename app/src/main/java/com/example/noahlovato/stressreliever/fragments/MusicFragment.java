package com.example.noahlovato.stressreliever.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.example.noahlovato.stressreliever.MainActivity;
import com.example.noahlovato.stressreliever.R;
import com.example.noahlovato.stressreliever.models.MusicAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {

    private static final String TAG = "MusicFragment";
    public boolean isPlaying;

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Log event for Fabric Answers
        Answers.getInstance().logCustom(new CustomEvent("Listening to relieving music"));

        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView)inflater.inflate(
                R.layout.fragment_music,container,false);

        int[] tracks = {R.raw.calming, R.raw.lightrain, R.raw.water_stream};

        //Fills recycler view with music tracks
        MusicAdapter musicAdapter = new MusicAdapter(tracks, getActivity());
        recyclerView.setAdapter(musicAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }

}
