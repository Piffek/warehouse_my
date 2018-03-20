package com.example.patrykpiwko.warehouse_my.base;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements NavigationInterface {

    protected abstract int getContentView();

    protected abstract int getFragmentContainer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        ButterKnife.bind(this);
    }

    @Override
    public void showFragment(Fragment fragment) {
        if(fragment == null) {
            return;
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(getFragmentContainer(), fragment).commit();
    }
}