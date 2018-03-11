package com.example.patrykpiwko.warehouse_my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLogIn:
                Log.d(TAG, "LogIn");
                break;
            case R.id.btnSignIn:
                Log.d(TAG, "SignIn");
                break;
            default:
                finish();
        }
    }
}
