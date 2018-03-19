package com.example.patrykpiwko.warehouse_my.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseFragment;

import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    @Override
    public int getContentFragment() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //All logic from this fragment
    }

    @OnClick(R.id.loginAuthButton)
    public void onClick(){
        if(getBaseActivityInterface() == null){
            Log.d(TAG, "onClick: method is null");
            return;
        }

        getBaseActivityInterface().showFragment(new RegisterFragment());

    }

}
