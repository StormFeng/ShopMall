package com.lida.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lida.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品素材
 * Created by WeiQingFeng on 2017/4/24.
 */

public class AdapterFragmentGoodSource extends BaseAdapter {

    private Context context;

    public AdapterFragmentGoodSource(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fragmentgoodsource, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.cb)
        CheckBox cb;
        @BindView(R.id.rl)
        RelativeLayout rl;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
