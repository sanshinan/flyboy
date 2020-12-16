package com.example.day01.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.day01.R;

public abstract class BaseFragment<P> extends Fragment  {
    protected P presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(setView(), null);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter==null){
            presenter=getPresenter();
        }
        initView(view);
    }

    protected abstract int setView();

    protected abstract void initView(View view);

    protected abstract P getPresenter();

}
