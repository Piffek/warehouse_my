package com.example.patrykpiwko.warehouse_my.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseActivity;
import com.example.patrykpiwko.warehouse_my.models.Movie;
import com.example.patrykpiwko.warehouse_my.utils.Utils;

import butterknife.BindView;
import butterknife.OnClick;

public class NewMovieActivity extends BaseActivity {

    public static int REQUEST_CODE = 200;
    public static String EXTRA_MOVIE = "EXTRA_MOVIE";

    @BindView(R.id.nameOfYourMovie)
    TextInputLayout nameOfYourMovie;

    @BindView(R.id.gradeOfYourMovie)
    TextInputLayout gradeOfYourMovie;

    public Movie getMovie(){
        nameOfYourMovie.setError(null);
        gradeOfYourMovie.setError(null);
        Movie movie = new Movie();

        String name = nameOfYourMovie.getEditText() != null ? nameOfYourMovie.getEditText().getText().toString() : null;
        String pictureURL = "https://picsum.photos/200/300/?image=110";
        Double grade = gradeOfYourMovie.getEditText() != null ? Utils.parseDouble(gradeOfYourMovie.getEditText().getText().toString()) : null;
        Integer year = 1969;
        Integer integerOfGrade;

         if(TextUtils.isEmpty(name)){
             nameOfYourMovie.setError("Name is empty");
             return null;
         }

         if(grade != null){
             grade*=10;
             integerOfGrade = grade.intValue();
             if (grade < 0 && grade > 10) {
                 gradeOfYourMovie.setError("grade range is incorrece");
                 return null;
             }
         }else{
             gradeOfYourMovie.setError("Grade is empty!");
             return null;
         }

        movie.setPictureURL(pictureURL);
        movie.setYear(year);
        movie.setGrade(integerOfGrade);
        movie.setTitle(name);

        return movie;
    }

    @OnClick(R.id.saveData)
    public void clickToButtonAndShowMenu(){
        Movie movie = getMovie();
        if(movie == null){
            return;
        }

        Intent intentForMovie = new Intent();
        intentForMovie.putExtra(EXTRA_MOVIE, getMovie());
        setResult(RESULT_OK, intentForMovie);
        finish();
    }

    @OnClick(R.id.exitFromAddNewMovie)
    public void clickToExitFromAddNewMovie(){
        setResult(RESULT_CANCELED);
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
