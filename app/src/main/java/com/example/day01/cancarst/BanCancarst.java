package com.example.day01.cancarst;

import com.example.day01.api.CallBack;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.TwoBean;

public interface BanCancarst {
    interface View{
        void onSson(TwoBean ban);
    }
    interface Presenter{
        void getBansonsp();
    }
    interface Model{
        void getSonse(CallBack callBack);
    }
}
