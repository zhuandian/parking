package com.example.toby.baimap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toby.MapUtils;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        final EditText etStart = (EditText) findViewById(R.id.et_start);
        final EditText etEnd = (EditText) findViewById(R.id.et_end);

        findViewById(R.id.tv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String start = etStart.getText().toString();
                String end = etEnd.getText().toString();
                if (TextUtils.isEmpty(start) || TextUtils.isEmpty(end)) {
                    Toast.makeText(NavigationActivity.this, "请完善目的地信息...", Toast.LENGTH_SHORT).show();
                    return;
                }

                MapUtils.openBaiduMap(NavigationActivity.this, start, end);

            }
        });
    }
}
