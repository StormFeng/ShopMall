package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lida.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 全部订单
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterInnerBooks extends BaseAdapter {

    private Context context;
    private int number;

    public AdapterInnerBooks(Context context, int number) {
        this.context = context;
        this.number = number;
    }

    @Override
    public int getCount() {
        return number;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_books_child, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.ivGood)
        ImageView ivGood;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvDes)
        TextView tvDes;
        @BindView(R.id.tvParams)
        TextView tvParams;
        @BindView(R.id.tvNewPrice)
        TextView tvNewPrice;
        @BindView(R.id.tvOldPrice)
        TextView tvOldPrice;
        @BindView(R.id.tvCount)
        TextView tvCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
