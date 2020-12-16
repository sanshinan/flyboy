package com.example.day01.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day01.R;
import com.example.day01.base.BaseAdapter;
import com.example.day01.bean.FistBean;
import com.example.day01.bean.TwoBean;

import java.util.List;

public class RecNewsAdapter extends BaseAdapter<TwoBean.StudenlistBean> {
    Context context;
    List<TwoBean.StudenlistBean> mData;
    public RecNewsAdapter(Context context, List<TwoBean.StudenlistBean> mData) {
        super(context, mData);
        this.context=context;
        this.mData=mData;
    }

    @Override
    protected int getAdapterView(int viewType) {
        return R.layout.item2;
    }

    @Override
    protected void bindData(int position, Vh holder, int type) {
        TwoBean.StudenlistBean bean = mData.get(position);
        TextView name = (TextView) holder.getViewById(R.id.item_2_name);
        TextView lilun = (TextView) holder.getViewById(R.id.item_2_lilun);
        TextView jine = (TextView) holder.getViewById(R.id.item_2_jine);
        name.setText("姓名:"+bean.getName());
        lilun.setText("机试成绩:"+bean.getSkill());
        jine.setText("理论成绩:"+bean.getTheory());
    }

    @Override
    protected int viewType(int position) {
        return 0;
    }
}
