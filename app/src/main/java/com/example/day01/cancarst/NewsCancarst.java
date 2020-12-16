package com.example.day01.cancarst;

import com.example.day01.api.CallBack;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.MaBanner;
import com.example.day01.bean.TwoBean;

public interface NewsCancarst {
    interface View{
        void onSson(FistBean ban);
    }
    interface Presenter{
        void getNewsonsp();
    }
    interface Model{
        void getSonse(CallBack callBack);
    }
}
