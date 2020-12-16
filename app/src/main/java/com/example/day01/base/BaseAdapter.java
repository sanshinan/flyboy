package com.example.day01.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter {
    private Context context;
    private List<D> mData;
    protected IListClick click;     //子类调用

    public BaseAdapter(Context context, List<D> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getAdapterView(viewType), parent, false);
        return new Vh(view);
    }

    @Override
    public int getItemViewType(int position) {
        return viewType(position);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Vh vh = (Vh) holder;
        int type = getItemViewType(position);
        //改：适配器，多布局，需要动态数据，所以下标也需要
        bindData(position,vh,type);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click!=null){
                    click.itemClick(position,v);
                }
            }
        });
    }



    @Override
    public int getItemCount() {     //多布局需重写即可
        return mData.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        SparseArray sparseArray=new SparseArray();
        public Vh(@NonNull View itemView) {
            super(itemView);
        }

        public View getViewById(int id){
            View view = (View) sparseArray.get(id);
            if (view==null){
                view=itemView.findViewById(id);
            }
            return view;
        }
    }

    public void addListClick(IListClick click){     //条目监听
        this.click = click;
    }

    //定义回调接口
    public interface IListClick{
        void itemClick(int pos,View view);
    }

    protected abstract int getAdapterView(int viewType);

    protected abstract void bindData(int position,Vh holder,int type);

    protected abstract int viewType(int position);      //多布局使用

}
