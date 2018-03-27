package com.example.patrykpiwko.warehouse_my.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

public class Movie implements Comparable<Movie>, Serializable {

    @NonNull
    private String title;

    private Integer year;

    @Nullable
    private String pictureURL;

    @Nullable
    private Integer grade;

    public Movie() {

    }

    public Movie(@NonNull String title, Integer year, String pictureURL, Integer grade) {
        this.title = title;
        this.year = year;
        this.pictureURL = pictureURL;
        this.grade = grade;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setPictureURL(@Nullable String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public void setGrade(@Nullable Integer grade) {
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