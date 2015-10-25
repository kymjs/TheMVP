package com.kymjs.frame.samples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kymjs.frame.samples.databind.DemoActivity;
import com.kymjs.frame.samples.mvp.SimpleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, DemoActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent());
                break;
            default:
                break;
        }
    }
}
