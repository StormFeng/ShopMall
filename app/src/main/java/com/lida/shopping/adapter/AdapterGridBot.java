package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lida.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页底部
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterGridBot extends BaseAdapter {

    private Context context;

    public AdapterGridBot(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridbot, null);
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
        @BindView(R.id.tvNewPrice)
        TextView tvNewPrice;
        @BindView(R.id.tvOldPrice)
        TextView tvOldPrice;
        @BindView(R.id.llGoodInfo)
        LinearLayout llGoodInfo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
