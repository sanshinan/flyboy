package com.example.day01.presenter;

import android.util.Log;

import com.example.day01.api.CallBack;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.MaBanner;
import com.example.day01.cancarst.Cancarst;
import com.example.day01.cancarst.NewsCancarst;
import com.example.day01.model.BanModel;
import com.example.day01.model.NewsModel;

public class NewsPresenter implements NewsCancarst.Presenter {
    NewsCancarst.View view;
    NewsCancarst.Model model;
    public NewsPresenter(NewsCancarst.View view) {
        this.view=view;
        this.model=new NewsModel();
    }
    @Override
    public void getNewsonsp() {
        model.getSonse(new CallBack() {
            @Override
            public void onSson(Object o) {
                view.onSson((FistBean) o);
            }
            @Override
            public void onErro(String ero) {
                Log.i("ban", "onErro: "+ero);
            }
        });
    }
}
