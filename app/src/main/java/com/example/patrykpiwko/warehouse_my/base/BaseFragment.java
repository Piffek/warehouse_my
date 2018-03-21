package com.example.patrykpiwko.warehouse_my.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.patrykpiwko.warehouse_my.activities.MainActivityInterface;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    public String TAG = getClass().getSimpleName();

    private NavigationInterface navigationInterface;
    private MainActivityInterface mainActivityInterface;

    public abstract int getContentFragment();

    public abstract String getTitle();

    public abstract int getCurrentSelected();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        if(getMainActivityInterface() != null){
            getMainActivityInterface().setTitle(getTitle());
            getMainActivityInterface().setCurrentSelected(getCurrentSelected());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getContentFragment(), container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(getActivity() instanceof NavigationInterface){
            navigationInterface = (NavigationInterface) getActivity();
        }

        if(getActivity() instanceof MainActivityInterface){
            mainActivityInterface = (MainActivityInterface) getActivity();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    public NavigationInterface getNavigationInterface() {
        return navigationInterface;
    }

    @Nullable
    public MainActivityInterface getMainActivityInterface(){
        return  mainActivityInterface;
    }
}