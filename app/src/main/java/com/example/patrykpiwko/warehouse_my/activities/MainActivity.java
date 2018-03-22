package com.example.patrykpiwko.warehouse_my.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseActivity;
import com.example.patrykpiwko.warehouse_my.fragments.CountriesFragment;
import com.example.patrykpiwko.warehouse_my.fragments.LoginFragment;
import com.example.patrykpiwko.warehouse_my.fragments.movies.MoviesFragment;
import com.example.patrykpiwko.warehouse_my.models.User;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements  MainActivityInterface{

    private User userData;

    @BindView(R.id.topTitle)
    TextView topTitle;

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.btn2)
    Button btn2;

    @BindView(R.id.btn3)
    Button btn3;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.containerFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showFragment(new LoginFragment());
    }


    @Override
    public void setTitle(String title) {
        if(title != null){
            topTitle.setText(title);
        }
    }

    @Override
    public void setCurrentSelected(int selected) {
        switch (selected){
            case 0:
                btn1.setBackgroundColor(ContextCompat.getColor(this, R.color.green_400));
                btn2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_200));
                btn3.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_200));
                break;
            case 1:
                btn1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_200));
                btn2.setBackgroundColor(ContextCompat.getColor(this, R.color.green_400));
                btn3.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_200));
                break;
            case 2:
                btn1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_200));
                btn2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_200));
                btn3.setBackgroundColor(ContextCompat.getColor(this, R.color.green_400));
                break;
        }
    }

    @Override
    public void setUserData(User user) {
        userData = user;
    }

    @Override
    public User getUsetData() {
        return userData;
    }

    @Override
    public void deleteUserData() {
        userData = null;
    }

    @OnClick(R.id.btn1)
    public void onBtn1Click(){
        showFragment(new LoginFragment());
    }

    @OnClick(R.id.btn2)
    public void onBtn2Click(){
        showFragment(new MoviesFragment());
    }

    @OnClick(R.id.btn3)
    public void onBtn3Click(){
        if(userData == null){
            Toast.makeText(this, "You have not access to this page", Toast.LENGTH_SHORT).show();
            return;
        }
        showFragment(new CountriesFragment());
    }
}