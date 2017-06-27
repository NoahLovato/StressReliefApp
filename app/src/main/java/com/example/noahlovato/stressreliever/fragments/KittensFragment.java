package com.example.noahlovato.stressreliever.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.example.noahlovato.stressreliever.ImageAdapter;
import com.example.noahlovato.stressreliever.R;
import com.example.noahlovato.stressreliever.models.LocalPhoto;


/**
 * A simple {@link Fragment} subclass.
 */
public class KittensFragment extends Fragment {

    private static final String TAG = "KittensFragment";

    public KittensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Log event for Fabric Answers
        Answers.getInstance().logCustom(new CustomEvent("Looking at kittens"));

        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView)inflater.inflate(
                R.layout.fragment_kittens,container,false);

        //gets references to photos in package
        LocalPhoto[] photos =
        {
            new LocalPhoto(R.drawable.download, "Cat 1"),
            new LocalPhoto(R.drawable.download1, "Cat 2"),
            new LocalPhoto(R.drawable.images, "Cat 3"),
            new LocalPhoto(R.drawable.images1, "Cat 4"),
            new LocalPhoto(R.drawable.images2, "Cat 5"),
            new LocalPhoto(R.drawable.images3, "Cat 6"),
            new LocalPhoto(R.drawable.images4, "Cat 7"),
            new LocalPhoto(R.drawable.images5, "Cat 8"),
            new LocalPhoto(R.drawable.images6, "Cat 9")
        };

        int[] ids = new int[photos.length];

        //sets array of photo ids
        for(int i = 0; i < ids.length; i++)
        {
            int id = photos[i].getId();
            Log.d(TAG, "Id is: " + id);
            ids[i] = id;
        }

        //Adapter for filling recycler view with images
        ImageAdapter imageAdapter = new ImageAdapter(ids);
        recyclerView.setAdapter(imageAdapter);

        //sets pictures to be in a grid with two columns
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }

}
