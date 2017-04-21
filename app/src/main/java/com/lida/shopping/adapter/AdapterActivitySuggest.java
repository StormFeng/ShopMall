package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.lida.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 意见反馈
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterActivitySuggest extends BaseAdapter {

    private Context context;
    private String[] data={"物流问题","商品问题","售后问题","软件问题","店主问题","其他问题"};

    public AdapterActivitySuggest(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.length;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activitysuggest, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.cb.setText(data[position]);
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
