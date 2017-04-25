package com.lida.shopping.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.lida.shopping.R;
import com.lida.shopping.activity.ActivityGoodDetail;
import com.midian.base.util.UIHelper;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页tab选项
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterHomeHarryBay extends BaseAdapter {

    private Context context;
    private int number;
    private String[] s = {"热门","上装","下装","鞋靴"};

    public AdapterHomeHarryBay(Context context, int number) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_harrybay, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump((Activity) context, ActivityGoodDetail.class);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.ivGood)
        ImageView ivGood;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvLimitNumber)
        TextView tvLimitNumber;
        @BindView(R.id.tvRemindNumber)
        TextView tvRemindNumber;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvEarnMoney)
        TextView tvEarnMoney;
        @BindView(R.id.btnBayNow)
        Button btnBayNow;
        @BindView(R.id.llItem)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
