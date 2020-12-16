package com.example.day01.api;

import com.example.day01.bean.FistBean;
import com.example.day01.bean.MaBanner;
import com.example.day01.bean.TwoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {
    String BASEURL="http://cdwan.cn:7000/";
    @GET("exam2003/abannerlist.json")
    Flowable<MaBanner> mBan();

    @GET("exam2003/anewslist.json")
    Flowable<FistBean> mFist();

    @GET("exam2003/astudent.json")
    Flowable<TwoBean> mTwo();
}
