package com.example.patrykpiwko.warehouse_my.fragments.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseFragment;
import com.example.patrykpiwko.warehouse_my.fragments.movies.adapter.MoviesAdapter;
import com.example.patrykpiwko.warehouse_my.models.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import butterknife.BindView;

public class MoviesFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public int getContentFragment() {
        return R.layout.fragment_movies;
    }

    @Override
    public String getTitle() {
        return "btn2";
    }

    @Override
    public int getCurrentSelected() {
        return 1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MoviesAdapter moviesAdapter = new MoviesAdapter(getMoviesList());

        recyclerView.setAdapter(moviesAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    List<Movie> getMoviesList(){
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie("Mad Max: Fury Road", 2015,"https://picsum.photos/200/300/?image=110",30);
        movieList.add(movie);

        movie = new Movie("Inside Out",  2015,"https://picsum.photos/200/300/?image=120",50);
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens",  2015,"https://picsum.photos/200/300/?image=130",50);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep",  2015,"https://picsum.photos/200/300/?image=104",50);
        movieList.add(movie);

        movie = new Movie("The Martian", 2015,"https://picsum.photos/200/300/?image=140",60);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", 2015,"https://picsum.photos/200/300/?image=150",100);
        movieList.add(movie);

        movie = new Movie("Up",  2009,"https://picsum.photos/200/300/?image=110",70);
        movieList.add(movie);

        movie = new Movie("Star Trek",  2009,"https://picsum.photos/200/300/?image=111",20);
        movieList.add(movie);

        movie = new Movie("The LEGO Movie",  2014,null,10);
        movieList.add(movie);

        movie = new Movie("Iron Man", 2008,null,null);
        movieList.add(movie);

        movie = new Movie("Aliens", 1986,null,10);
        movieList.add(movie);

        movie = new Movie("Chicken Run", 2000,"https://picsum.photos/200/300/?image=500",null);
        movieList.add(movie);

        movie = new Movie("Back to the Future" ,1985,"https://picsum.photos/200/300/?image=600",80);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", 1981,"https://picsum.photos/200/300/?image=700",70);
        movieList.add(movie);

        movie = new Movie("Goldfinger" ,1965,"https://picsum.photos/200/300/?image=800",50);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", 2014,"https://picsum.photos/200/300/?image=900",50);
        movieList.add(movie);

        Collections.sort(movieList);

        return movieList;
    }
}