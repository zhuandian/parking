package com.example.toby.baimap;

import android.app.Application;

import cn.bmob.v3.Bmob;


public class Data extends Application {
    private String b;//账号
    private String c;//车号
    private double d;//单价
    //private String depot;//停车场编号


    public String getB(){
        return this.b;
    }
    public void setB(String c){
        this.b= c;
    }
    public String getC(){
        return this.c;
    }
    public void setC(String c1){
        this.c=c1;
    }
    public double getD(){
        return this.d;
    }
    public void setD(double d){
        this.d=d;
    }



    @Override
    public void onCreate(){
        b = "test";
        c="001";
        d=12;
        //depot="002";
        super.onCreate();
        Bmob.initialize(this, "1c99d26ffcbf12cbf1f1560d9ab09345");
    }
}

