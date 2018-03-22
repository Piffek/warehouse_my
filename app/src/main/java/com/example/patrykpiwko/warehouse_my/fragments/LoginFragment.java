package com.example.patrykpiwko.warehouse_my.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseFragment;
import com.example.patrykpiwko.warehouse_my.models.User;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    @BindView(R.id.nameInputLogin)
    EditText nameInputLogin;

    public String toDestroy = "";

    @Override
    public int getContentFragment() {
        return R.layout.fragment_login;
    }

    @Override
    public String getTitle() {
        return "title";
    }

    @Override
    public int getCurrentSelected() {
        return 0;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //All logic from this fragment
    }

    @OnClick(R.id.loginAuthButton)
    public void onClick(){
        String name = nameInputLogin.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(getActivity(), "imie !", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User();
        user.setName(name);

        if(getMainActivityInterface() != null){
            getMainActivityInterface().setUserData(user);
        }

        if(getNavigationInterface() != null){
            getNavigationInterface().showFragment(new CountriesFragment());
        }
    }

    @Override
    public void onDestroy() {
        toDestroy = null;
        nameInputLogin.setText("");

        super.onDestroy();
    }
}