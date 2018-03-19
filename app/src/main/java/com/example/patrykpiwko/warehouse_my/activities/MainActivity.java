package com.example.patrykpiwko.warehouse_my.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.patrykpiwko.warehouse_my.fragments.LoginFragment;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseActivity;
import com.example.patrykpiwko.warehouse_my.fragments.RegisterFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @BindView(R.id.btnLogIn)
    Button loginButton;

    @BindView(R.id.btnSignIn)
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btnLogIn)
    public void onLoginButtonClick(){
        showFragment(new LoginFragment());
    }

    @OnClick(R.id.btnSignIn)
    public void onRegisterButtonClick(){
        showFragment(new RegisterFragment());
    }

    @OnClick(R.id.btnTask1)
    public void showTask1(){
        Intent moveToTask1 = new Intent(MainActivity.this, Task1Activity.class);
        startActivity(moveToTask1);
    }

    @OnClick(R.id.btnTask2)
    public void showTask2(){
        Intent moveToTask2 = new Intent(MainActivity.this, Task2Activity.class);
        startActivity(moveToTask2);
    }

    @OnClick(R.id.btnTask3)
    public void showTask3(){
        Intent moveToTask3 = new Intent(MainActivity.this, Task3Activity.class);
        startActivity(moveToTask3);
    }
}