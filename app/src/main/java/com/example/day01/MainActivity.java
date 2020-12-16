package com.example.day01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day01.ui.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private ImageView img;
    private EditText user;
    private EditText pwd;
    String USERID="H2003xs";
    String PWD="H2003";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        user = findViewById(R.id.et_top_user);
        pwd = findViewById(R.id.et_top_pwd);
        View but = findViewById(R.id.but_yes);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = user.getText().toString();
                String pw = pwd.getText().toString();
                if (USERID.equals(us) && PWD.equals(pw)){
                    SharedPreferences sp = getSharedPreferences("sp_dgon", MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("isLogin",true);
                    edit.commit();
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });
    }
}