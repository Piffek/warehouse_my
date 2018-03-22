package com.example.patrykpiwko.warehouse_my.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Movie {

    @NonNull
    private String title;

    @NonNull
    private String year;

    @Nullable
    private String pictureURL;

    @Nullable
    private Integer grade;

    public Movie(@NonNull String title, @NonNull String year, String pictureURL, Integer grade) {
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
    public String getYear() {
        return year;
    }

    @Nullable
    public String getPictureURL() {
        return pictureURL;
    }

    @Nullable
    public Integer getGrade() {
        return grade;
    }
}
