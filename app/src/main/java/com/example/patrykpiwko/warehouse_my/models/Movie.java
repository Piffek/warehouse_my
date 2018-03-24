package com.example.patrykpiwko.warehouse_my.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Movie implements Comparable<Movie> {

    @NonNull
    private String title;

    private Integer year;

    @Nullable
    private String pictureURL;

    @Nullable
    private Integer grade;

    public Movie(@NonNull String title, Integer year, String pictureURL, Integer grade) {
        this.title = title;
        this.year = year;
        this.pictureURL = pictureURL;
        this.grade = grade;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public int getYear() {
        if(year != null){
            return year;
        }
        return 0;
    }

    @Nullable
    public int getGrade() {
        if(grade != null){
            return grade;
        }
        return 0;
    }

    @Nullable
    public String getPictureURL() {
        return pictureURL;
    }


    @Override
    public int compareTo(@NonNull Movie movie) {
        return year.compareTo(movie.getYear());
    }
}