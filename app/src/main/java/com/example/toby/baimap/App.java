package com.example.toby.baimap;

import android.app.Application;

import cn.bmob.v3.Bmob;


public class App extends Application {



    @Override
    public void onCreate(){
        super.onCreate();
        Bmob.initialize(this, "1c99d26ffcbf12cbf1f1560d9ab09345");
    }
}

