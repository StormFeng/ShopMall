package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lida.shopping.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分类 左侧大类
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterTypeList extends BaseAdapter {

    private Context context;
    private String[] s = {"热门","上装","下装","鞋靴","箱包","护肤","美妆","精品","配饰"};
    private List<Boolean> status=new ArrayList<>();

    public AdapterTypeList(Context context) {
        this.context = context;
        for (int i = 0; i < s.length; i++) {
            if(i==0){
                status.add(true);
            }else{
                status.add(false);
            }
        }
    }

    @Override
    public int getCount() {
        return s.length;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_typelist, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.cb.setText(s[position]);
        if(status.get(position)){
            viewHolder.cb.setChecked(true);
        }else{
            viewHolder.cb.setChecked(false);
        }
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < status.size(); i++) {
                    status.set(i,false);
                }
                status.set(position,true);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.cb)
        CheckBox cb;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
