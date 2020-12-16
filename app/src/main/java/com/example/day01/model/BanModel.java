package com.example.day01.model;

import com.example.day01.api.ApiService;
import com.example.day01.api.CallBack;
import com.example.day01.bean.MaBanner;
import com.example.day01.cancarst.Cancarst;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BanModel implements Cancarst.Model {
    @Override
    public void getSonse(CallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .mBan()
                .compose(new FlowableTransformer<MaBanner,MaBanner>() {
                    @NonNull
                    @Override
                    public Publisher<MaBanner> apply(@NonNull Flowable<MaBanner> upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .subscribeWith(new ResourceSubscriber<MaBanner>() {
                    @Override
                    public void onNext(MaBanner maBanner) {
                        callBack.onSson(maBanner);
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
