package com.example.noahlovato.stressreliever.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noahlovato.stressreliever.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {

    private static final String TAG = "MusicFragment";

    public MusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

}
