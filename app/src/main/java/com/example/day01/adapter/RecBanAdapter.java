package com.example.day01.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day01.R;
import com.example.day01.base.BaseAdapter;
import com.example.day01.bean.FistBean;

import java.util.List;

public class RecBanAdapter extends BaseAdapter<FistBean.NewsBean> {
    Context context;
    List<FistBean.NewsBean> mData;
    public RecBanAdapter(Context context, List<FistBean.NewsBean> mData) {
        super(context, mData);
        this.context=context;
        this.mData=mData;
    }

    @Override
    protected int getAdapterView(int viewType) {
        return R.layout.item1;
    }

    @Override
    protected void bindData(int position, Vh holder, int type) {
        FistBean.NewsBean newsBean = mData.get(position);
        ImageView img = (ImageView) holder.getViewById(R.id.item_1_img);
        TextView title = (TextView) holder.getViewById(R.id.item_1_title);
        TextView body = (TextView) holder.getViewById(R.id.item_1_body);
        title.setText(newsBean.getTile());
        body.setText(newsBean.getContent());
        Glide.with(context).load(newsBean.getImageUrl()).into(img);
    }

    @Override
    protected int viewType(int position) {
        return 0;
    }
}
