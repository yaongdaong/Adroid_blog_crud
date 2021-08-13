package com.com.blog.view.auth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.com.blog.R;
import com.com.blog.view.InitActivity;


public class LoginActivity extends AppCompatActivity implements InitActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void init() {

    }

    @Override
    public void initLr() {

    }

    @Override
    public void initSetting() {

    }
}