package com.example.patrykpiwko.warehouse_my.fragments;

import android.widget.TextView;

import com.example.patrykpiwko.warehouse_my.base.BaseFragment;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.models.User;

import butterknife.BindView;


public class CountriesFragment extends BaseFragment {

    @BindView(R.id.userName)
    TextView userName;

    @BindView(R.id.userPassword)
    TextView userPassword;

    @Override
    public int getContentFragment() {
        return R.layout.fragment_countries;
    }

    @Override
    public String getTitle() {
        return "btn3";
    }

    @Override
    public int getCurrentSelected() {
        return 2;
    }
}
