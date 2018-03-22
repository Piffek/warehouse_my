package com.example.patrykpiwko.warehouse_my.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.patrykpiwko.warehouse_my.activities.MainActivity;
import com.example.patrykpiwko.warehouse_my.activities.MainActivityInterface;
import com.example.patrykpiwko.warehouse_my.base.BaseFragment;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.models.User;

import butterknife.BindView;
import butterknife.OnClick;


public class CountriesFragment extends BaseFragment {

    @BindView(R.id.userName)
    TextView nameOfUser;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getMainActivityInterface() instanceof MainActivityInterface){
            User user = getMainActivityInterface().getUsetData();
            if(user != null){
                nameOfUser.setText(user.name);
            }
        }
    }

    @OnClick(R.id.deleteText)
    public void onClick(){
        if(getMainActivityInterface() instanceof MainActivity){
            nameOfUser.setText("");
            getMainActivityInterface().deleteUserData();
        }
    }

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
