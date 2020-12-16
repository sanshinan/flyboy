package com.example.day01.presenter;

import android.util.Log;

import com.example.day01.api.CallBack;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.TwoBean;
import com.example.day01.cancarst.BanCancarst;
import com.example.day01.cancarst.Cancarst;
import com.example.day01.cancarst.NewsCancarst;
import com.example.day01.model.FBanModel;
import com.example.day01.model.NewsModel;

public class FBanPresenter implements BanCancarst.Presenter {
    BanCancarst.View view;
    BanCancarst.Model model;
    public FBanPresenter(BanCancarst.View view) {
        this.view=view;
        this.model=new FBanModel();
    }

    @Override
    public void getBansonsp() {
        model.getSonse(new CallBack() {
            @Override
            public void onSson(Object o) {
                view.onSson((TwoBean) o);
            }
            @Override
            public void onErro(String ero) {
                Log.i("ban", "onErro: "+ero);
            }
        });
    }
}
