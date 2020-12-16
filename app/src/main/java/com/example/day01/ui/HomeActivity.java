package com.example.day01.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.day01.R;
import com.example.day01.adapter.ViewPagAdapter;
import com.example.day01.base.BaseActivity;
import com.example.day01.bean.MaBanner;
import com.example.day01.cancarst.Cancarst;
import com.example.day01.fragment.BanFragment;
import com.example.day01.fragment.NewsFragment;
import com.example.day01.model.BanModel;
import com.example.day01.presenter.BanPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<BanPresenter> implements Cancarst.View {

    private Banner ban;
    private TabLayout tab;
    private ViewPager pag;
    private List<MaBanner.BannerlistBean> mBan;
    private BannerImageAdapter<MaBanner.BannerlistBean> imageAdapter;
    private ViewPagAdapter pagAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        ban = findViewById(R.id.ban);
        tab = findViewById(R.id.tab);
        pag = findViewById(R.id.page);
        mBan = new ArrayList<>();
    }

    @Override
    protected void initData() {
        presenter.getSonsp();
        inBan();
        inTab();
    }

    private void inTab() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new BanFragment());
        pagAdapter = new ViewPagAdapter(getSupportFragmentManager(), fragments);
        pag.setAdapter(pagAdapter);
        tab.setupWithViewPager(pag);
        tab.getTabAt(0).setText("学校新闻");
        tab.getTabAt(1).setText("班级查讯");
    }

    private void inBan() {
        imageAdapter = new BannerImageAdapter<MaBanner.BannerlistBean>(mBan) {
            @Override
            public void onBindView(BannerImageHolder holder, MaBanner.BannerlistBean data, int position, int size) {
                Glide.with(HomeActivity.this).load(data.getImageurl()).into(holder.imageView);
            }
        };
        ban.setBannerGalleryEffect(15,15);
        ban.setAdapter(imageAdapter);
    }

    @Override
    protected BanPresenter getPresenter() {
        return new BanPresenter(this);
    }

    @Override
    public void onSson(MaBanner ban) {
        Log.i("1111", "onSson: "+ban.toString());
        mBan.addAll(ban.getBannerlist());
        imageAdapter.notifyDataSetChanged();
    }
}