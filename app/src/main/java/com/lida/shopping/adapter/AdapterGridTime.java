package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lida.shopping.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页时间线选择
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterGridTime extends BaseAdapter {

    private Context context;
    private String[] s1 = {"昨天", "10:00", "20:00", "明天"};
    private String[] s2 = {"已开抢", "抢购中", "预热中", "预告中"};
    private List<Boolean> status;
    private OnTimeChangeListener listener;

    public AdapterGridTime(Context context,List<Boolean> status) {
        this.context = context;
        this.status = status;
        for (int i = 0; i < s1.length; i++) {
            if(i==0){
                this.status.add(false);
            }else{
                this.status.add(true);
            }
        }
    }

    @Override
    public int getCount() {
        return s1.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_timeline, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTime.setText(s1[position]);
        viewHolder.tvStatu.setText(s2[position]);
        if(status.get(position)){
            viewHolder.tvStatu.setEnabled(true);
            viewHolder.tvTime.setEnabled(true);
        }else{
            viewHolder.tvStatu.setEnabled(false);
            viewHolder.tvTime.setEnabled(false);
        }
        viewHolder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < status.size(); i++) {
                    status.set(i,true);
                }
                status.set(position,false);
                notifyDataSetChanged();
                listener.changePage(position);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvTime)
        TextView tvTime;
        @BindView(R.id.tvStatu)
        TextView tvStatu;
        @BindView(R.id.llItem)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface OnTimeChangeListener{
        void changePage(int position);
    }

    public void setOnTimeChangeListener(OnTimeChangeListener listener){
        this.listener = listener;
    }
}
