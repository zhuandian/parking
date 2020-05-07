package com.example.toby.baimap;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class ParkingState extends AppCompatActivity {
    private TextView pView;
    private Button parkEnd;
    private Chronometer timer;
    private String username,parkid;
    private int num;

    private static double price;
    private String priceStr;
    private Runnable uiRunnable = new Runnable() {
        @Override
        public void run() {
            pView.setText(priceStr);
        }};
    private Handler handler= null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_state);
        pView= (TextView) findViewById(R.id.pView);
        parkEnd= (Button) findViewById(R.id.parkEnd);
        timer= (Chronometer) findViewById(R.id.timer);
        timeStart();
        //ParkP();
        Timer mTimer =new Timer();
        //int temp = 0;
        handler = new Handler();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                priceCount(5);
                handler.post(uiRunnable);

            }
        },1000,5000);
        parkEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                ParkEnd(v);
                jump();

            }
        });



    }

    private void timeStart() {
        timer.setBase(SystemClock.elapsedRealtime());//计时器清零
        int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
        timer.setFormat("0"+String.valueOf(hour)+":%s");
        timer.start();
    }
    private void priceCount(double b){
        int temp0=Integer.parseInt(timer.getText().toString().split(":")[0]);
        int temp1=Integer.parseInt(timer.getText().toString().split(":")[1]);
        //int temp2=Integer.parseInt(timer.getText().toString().split(":")[2]);
        int stopTime=temp0*60+temp1;

        double pri=b/4;
        //Log.e("e",stopTime+"");
        if (stopTime<0) price=0;
        else {
            price=(stopTime+1)*pri;
        }
        //Log.e("tag" ,price+"");
        priceStr=price+"元";
//        pView.setText(str);
        //pView.setText(price+"");
        //timer.stop();
    }
    private void ParkEnd(View v) {

        jump();
    }



    private void jump() {
        Intent intent =new Intent();
        intent.setClass(ParkingState.this, CarParkingActivity.class);
        ParkingState.this.startActivity(intent);
    }

}
