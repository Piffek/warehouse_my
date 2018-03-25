package com.example.patrykpiwko.warehouse_my.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseActivity;
import com.example.patrykpiwko.warehouse_my.models.Movie;
import butterknife.OnClick;

public class NewMovieActivity extends BaseActivity {

    public static int REQUEST_CODE = 200;
    public static String EXTRA_MOVIE = "EXTRA_MOVIE";

    @OnClick(R.id.saveData)
    public void clickToButtonAndShowMenu(){
        Movie movie = new Movie("ANYTHING", 2019,"https://picsum.photos/200/300/?image=110",30);
        Intent intentForMovie = new Intent();
        intentForMovie.putExtra(EXTRA_MOVIE, movie);
        setResult(RESULT_OK, intentForMovie);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_new_movie;
    }

    @Override
    protected int getFragmentContainer() {
        return 0;
    }
}
