package com.example.patrykpiwko.warehouse_my.activities;

import com.example.patrykpiwko.warehouse_my.models.User;

public interface MainActivityInterface {
    public void setTitle(String title);

    public void setCurrentSelected(int selected);

    public void setUserData(User user);

    public User getUsetData();
}
