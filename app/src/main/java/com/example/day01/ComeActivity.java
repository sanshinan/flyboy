package com.example.day01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

public class ComeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come);
        initView();
    }

    private void initView() {
        SharedPreferences sp = getSharedPreferences("sp_dgon", MODE_PRIVATE);
        boolean login = sp.getBoolean("isLogin", false);
        if (login){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
        TextView tex = findViewById(R.id.time_tex);
        Disposable disposable = Observable.intervalRange(0,6, 0,1,TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tex.setText(5-aLong + "");
                                if (aLong>5){
                                    startActivity(new Intent(ComeActivity.this,MainActivity.class));
                                    finish();
                                }
                            }
                        });
                    }
                });
        tex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disposable.isDisposed();
                startActivity(new Intent(ComeActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}