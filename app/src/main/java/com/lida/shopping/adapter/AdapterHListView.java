package com.lida.shopping.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lida.shopping.R;
import com.lida.shopping.activity.ActivitySpecial;
import com.midian.base.util.UIHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 推荐商品
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterHListView extends BaseAdapter {

    private Context context;

    public AdapterHListView(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hlistview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(position==3){
            viewHolder.llGoodInfo.setVisibility(View.GONE);
            viewHolder.btnLookMore.setVisibility(View.VISIBLE);
        }else{
            viewHolder.llGoodInfo.setVisibility(View.VISIBLE);
            viewHolder.btnLookMore.setVisibility(View.GONE);
        }
        viewHolder.btnLookMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump((Activity) context, ActivitySpecial.class);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.ivGood)
        ImageView ivGood;
        @BindView(R.id.tvNewPrice)
        TextView tvNewPrice;
        @BindView(R.id.tvOldPrice)
        TextView tvOldPrice;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.btnLookMore)
        TextView btnLookMore;
        @BindView(R.id.llGoodInfo)
        LinearLayout llGoodInfo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
