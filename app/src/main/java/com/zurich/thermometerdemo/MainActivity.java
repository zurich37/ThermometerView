package com.zurich.thermometerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zurich.thermometer.ThermometerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThermometerView thermometerView = findViewById(R.id.thermometer_view);
        thermometerView.setMax(100);
        thermometerView.setProgress(66.6f);
    }
}
