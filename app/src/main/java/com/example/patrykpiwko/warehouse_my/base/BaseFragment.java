package com.example.patrykpiwko.warehouse_my.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    public String TAG = getClass().getSimpleName();

    BaseActivityInterface baseActivityInterface;

    public abstract int getContentFragment();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getContentFragment(), container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(getActivity() instanceof BaseActivityInterface){
            baseActivityInterface = (BaseActivityInterface) getActivity();
        }
    }

    @Nullable
    public BaseActivityInterface getBaseActivityInterface() {
        return baseActivityInterface;
    }
}