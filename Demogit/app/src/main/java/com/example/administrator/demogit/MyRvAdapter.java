package com.example.administrator.demogit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.Vh>{

private String[]dataUrl;

    public MyRvAdapter(String[] dataUrl) {
        this.dataUrl = dataUrl;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Vh(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(Vh holder, int position) {
        Picasso.with(holder.itemView.getContext()).load(dataUrl[position]).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return dataUrl.length;
    }

    public class Vh extends RecyclerView.ViewHolder{
        public ImageView iv;

        public Vh(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
