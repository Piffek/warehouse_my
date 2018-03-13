package com.example.patrykpiwko.warehouse_my;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    Button signInButton;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.btnLogIn);
        loginButton.setOnClickListener(this);

        Button signInButton = (Button) findViewById(R.id.btnSignIn);
        signInButton.setOnClickListener(this);

        Button taskOne = (Button) findViewById(R.id.btnTask1);
        taskOne.setOnClickListener(this);

        Button taskTwo = (Button) findViewById(R.id.btnTask2);
        taskTwo.setOnClickListener(this);

        Button taskThree = (Button) findViewById(R.id.btnTask3);
        taskThree.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment authFragment;
        switch(view.getId()){
            case R.id.btnLogIn:
                authFragment = new LoginFragment();
                ft.replace(R.id.authFragment, authFragment).commit();
                break;
            case R.id.btnSignIn:
                authFragment = new RegisterFragment();
                ft.replace(R.id.authFragment, authFragment).commit();
                break;
            case R.id.btnTask1:
                Intent moveToTask1 = new Intent(MainActivity.this, Task1Activity.class);
                startActivity(moveToTask1);
            case R.id.btnTask2:
                Intent moveToTask2 = new Intent(MainActivity.this, Task2Activity.class);
                startActivity(moveToTask2);
            case R.id.btnTask3:
                Intent moveToTask3 = new Intent(MainActivity.this, Task3Activity.class);
                startActivity(moveToTask3);
            default:
                finish();
        }
    }
}
