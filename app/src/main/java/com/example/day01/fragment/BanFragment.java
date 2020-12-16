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
import com.example.day01.adapter.RecNewsAdapter;
import com.example.day01.base.BaseFragment;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.TwoBean;
import com.example.day01.cancarst.BanCancarst;
import com.example.day01.presenter.FBanPresenter;

import java.util.ArrayList;
import java.util.List;

public class BanFragment extends BaseFragment<FBanPresenter> implements BanCancarst.View {


    private RecyclerView rec;
    private ArrayList<TwoBean.StudenlistBean> mBan;
    private RecNewsAdapter recNewsAdapter;

    @Override
    protected int setView() {
        return R.layout.frag_ban;
    }
    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_ban);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBan = new ArrayList<>();
        recNewsAdapter = new RecNewsAdapter(getActivity(), mBan);
        rec.addItemDecoration(new DividerGridItemDecoration());
        rec.setAdapter(recNewsAdapter);
        presenter.getBansonsp();
    }

    @Override
    protected FBanPresenter getPresenter() {
        return new FBanPresenter(this);
    }


    @Override
    public void onSson(TwoBean ban) {
        mBan.addAll(ban.getStudenlist());
        recNewsAdapter.notifyDataSetChanged();
    }
}
