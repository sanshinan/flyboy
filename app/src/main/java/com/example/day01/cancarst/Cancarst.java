package com.example.day01.cancarst;

import com.example.day01.api.CallBack;
import com.example.day01.bean.MaBanner;
import com.example.day01.model.BanModel;

public interface Cancarst {
    interface View{
        void onSson(MaBanner ban);
    }
    interface Presenter{
        void getSonsp();
    }
    interface Model{
        void getSonse(CallBack callBack);
    }
}
