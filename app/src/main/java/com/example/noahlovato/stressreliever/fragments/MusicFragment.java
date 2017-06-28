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

        String[] tracks = {"Song 1", "Song 2", "Song 3","Song 4", "Song 5", "Song 6",
                "Song 7", "Song 8", "Song 9","Song 10", "Song 11",
                "Song 12","Song 13", "Song 14", "Song 15"};

        //Fills recycler view with music tracks
        MusicAdapter musicAdapter = new MusicAdapter(tracks);
        recyclerView.setAdapter(musicAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }

}
