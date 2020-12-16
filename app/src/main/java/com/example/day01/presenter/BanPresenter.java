package com.example.day01.presenter;

import android.util.Log;

import com.example.day01.api.CallBack;
import com.example.day01.bean.MaBanner;
import com.example.day01.cancarst.Cancarst;
import com.example.day01.model.BanModel;

public class BanPresenter implements Cancarst.Presenter {
    Cancarst.View view;
    Cancarst.Model model;
    public BanPresenter(Cancarst.View view) {
        this.view=view;
        this.model=new BanModel();
    }

    @Override
    public void getSonsp() {
        model.getSonse(new CallBack() {
            @Override
            public void onSson(Object o) {
                view.onSson((MaBanner) o);
            }

            @Override
            public void onErro(String ero) {
                Log.i("ban", "onErro: "+ero);
            }
        });
    }
}
