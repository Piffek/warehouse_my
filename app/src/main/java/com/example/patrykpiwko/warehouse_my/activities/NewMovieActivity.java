package com.example.patrykpiwko.warehouse_my.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseActivity;
import com.example.patrykpiwko.warehouse_my.models.Movie;
import com.example.patrykpiwko.warehouse_my.utils.Utils;
import android.widget.PopupMenu.OnMenuItemClickListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class NewMovieActivity extends BaseActivity implements OnMenuItemClickListener {

    public static int REQUEST_CODE = 200;
    public static String EXTRA_MOVIE = "EXTRA_MOVIE";

    @BindView(R.id.nameOfYourMovie)
    TextInputLayout nameOfYourMovie;

    @BindView(R.id.gradeOfYourMovie)
    TextInputLayout gradeOfYourMovie;

    @BindView(R.id.popUpButtonWithYear)
    Button popUpButtonWithYear;

    public Movie getMovie(){
        nameOfYourMovie.setError(null);
        gradeOfYourMovie.setError(null);
        Movie movie = new Movie();

        String name = nameOfYourMovie.getEditText() != null ? nameOfYourMovie.getEditText().getText().toString() : null;
        Double grade = gradeOfYourMovie.getEditText() != null ? Utils.parseDouble(gradeOfYourMovie.getEditText().getText().toString()) : null;
        Random rand = new Random();
        String pictureURL = "https://picsum.photos/200/300/?image=" +(100 + (int)(Math.random() * ((900 - 100) + 1)));
        Log.d("cos", pictureURL);
        Integer year = 1969;
        Integer integerOfGrade;

         if(TextUtils.isEmpty(name)){
             nameOfYourMovie.setError("Name is empty");
             return null;
         }

         if(grade != null){
             grade*=10;
             integerOfGrade = grade.intValue();
             if (integerOfGrade <= 0 || integerOfGrade > 100) {
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

    @OnClick(R.id.popUpButtonWithYear)
    public void showPopUpMenu(){
        PopupMenu popUp = new PopupMenu(this, popUpButtonWithYear);
        for(int i = 0; i < arrayWithYear().size(); i++){
            popUp.getMenu().add(Menu.NONE, i, Menu.NONE, arrayWithYear().get(i).toString());
        }
        popUp.setOnMenuItemClickListener(this);
        popUp.show();
    }

    public List arrayWithYear(){
        List<Integer> listWithYear = new ArrayList<Integer>();
        listWithYear.add(2000);
        listWithYear.add(2001);
        listWithYear.add(2002);
        listWithYear.add(2003);
        listWithYear.add(2004);
        return listWithYear;
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

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case 0:
                Log.d("MENU", "click to"+menuItem.getItemId());
                break;
            case 1:
                Log.d("MENU", "click to"+menuItem.getItemId());
                break;
            case 2:
                Log.d("MENU", "click to"+menuItem.getItemId());
                break;
        }
        return false;
    }
}
