package com.example.itp.sample_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITP on 6/16/2017.
 */

public class Fragment2 extends Fragment {
    View view;
    private ArrayList<Movie> movieList = new ArrayList<>();
    RecyclerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);

        RecyclerView rc = (RecyclerView) view.findViewById(R.id.recyclerview);

        mAdapter = new RecyclerAdapter(getActivity(), movieList, rc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rc.setLayoutManager(linearLayoutManager);
        rc.setHasFixedSize(true);
        rc.setItemAnimator(new DefaultItemAnimator());
        rc.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "5");
        movieList.add(movie);

        movie = new Movie("Inside Out", "4");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "1");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "0");
        movieList.add(movie);

        movie = new Movie("The Martian", "2");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "3");
        movieList.add(movie);

        movie = new Movie("Up", "4");
        movieList.add(movie);

        movie = new Movie("Star Trek", "0");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "2");
        movieList.add(movie);

        movie = new Movie("Iron Man", "3");
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }
}
