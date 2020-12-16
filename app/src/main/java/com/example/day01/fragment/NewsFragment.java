package com.example.day01.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day01.DividerGridItemDecoration;
import com.example.day01.R;
import com.example.day01.adapter.RecBanAdapter;
import com.example.day01.base.BaseFragment;
import com.example.day01.bean.FistBean;
import com.example.day01.cancarst.NewsCancarst;
import com.example.day01.presenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsCancarst.View {

    private RecyclerView rec;
    private List<FistBean.NewsBean> mBan;
    private RecBanAdapter banAdapter;

    @Override
    protected int setView() {
        return R.layout.frag_news;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_news);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBan = new ArrayList<>();
        banAdapter = new RecBanAdapter(getActivity(), mBan);
        rec.setAdapter(banAdapter);
        rec.addItemDecoration(new DividerGridItemDecoration());
        initData();
    }

    @Override
    protected NewsPresenter getPresenter() {
        return new NewsPresenter(this);
    }

    private void initData() {
        presenter.getNewsonsp();
    }

    @Override
    public void onSson(FistBean ban) {
        mBan.addAll(ban.getNews());
        banAdapter.notifyDataSetChanged();
    }
}
