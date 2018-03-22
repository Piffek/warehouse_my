package com.example.patrykpiwko.warehouse_my.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Country {

    private int peopleAmount;
    private String pictureURL;

    @NonNull
    private String capital;

    @NonNull
    private String name;

    @Nullable
    private String language;

    public Country(int peopleAmount, String pictureURL, @NonNull String capital, @NonNull String name, String language) {
        this.peopleAmount = peopleAmount;
        this.pictureURL = pictureURL;
        this.capital = capital;
        this.name = name;
        this.language = language;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    @NonNull
    public String getCapital() {
        return capital;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getLanguage() {
        return language;
    }

    public int getPeopleAmount() {

        return peopleAmount;
    }
}
