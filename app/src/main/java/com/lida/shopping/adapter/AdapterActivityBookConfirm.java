package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lida.shopping.R;
import com.lida.shopping.widget.NumberWidgetCopy;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单确认
 * Created by WeiQingFeng on 2017/4/24.
 */

public class AdapterActivityBookConfirm extends BaseAdapter {

    private Context context;

    public AdapterActivityBookConfirm(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activitybookconfirm, null);
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
        @BindView(R.id.tvGoodName)
        TextView tvGoodName;
        @BindView(R.id.tvGoodParam)
        TextView tvGoodParam;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.etNumber)
        NumberWidgetCopy etNumber;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
