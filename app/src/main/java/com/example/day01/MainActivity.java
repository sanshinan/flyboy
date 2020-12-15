package com.example.day01;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        img = (ImageView) findViewById(R.id.img);
        text.setText("Android 4.1.1版本");
        img.setImageResource(R.mipmap.ic_launcher);
    }
}