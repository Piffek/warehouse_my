package com.example.patrykpiwko.warehouse_my.fragments;

import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.base.BaseFragment;

public class ResultFragment extends BaseFragment {



    @Override
    public int getContentFragment() {
        return R.layout.fragment_result;
    }

    @Override
    public String getTitle() {
        return "btn2";
    }

    @Override
    public int getCurrentSelected() {
        return 1;
    }
}
