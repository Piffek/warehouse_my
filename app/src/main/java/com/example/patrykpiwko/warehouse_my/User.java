package com.example.patrykpiwko.warehouse_my;

public class User {
    public String name;
    public String password;
    public String email;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
