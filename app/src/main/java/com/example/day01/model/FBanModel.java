package com.example.day01.model;

import com.example.day01.api.ApiService;
import com.example.day01.api.CallBack;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.TwoBean;
import com.example.day01.cancarst.BanCancarst;
import com.example.day01.cancarst.Cancarst;
import com.example.day01.cancarst.NewsCancarst;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FBanModel implements BanCancarst.Model {
    @Override
    public void getSonse(CallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
               .mTwo()
                .compose(new FlowableTransformer<TwoBean,TwoBean>() {
                    @NonNull
                    @Override
                    public Publisher<TwoBean> apply(@NonNull Flowable<TwoBean> upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .subscribeWith(new ResourceSubscriber<TwoBean>() {
                    @Override
                    public void onNext(TwoBean twoBean) {
                        callBack.onSson(twoBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onErro(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
