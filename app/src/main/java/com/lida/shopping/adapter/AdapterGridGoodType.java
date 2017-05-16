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
import com.lida.shopping.activity.ActivityGlobal;
import com.lida.shopping.activity.ActivityHotList;
import com.lida.shopping.activity.ActivitySpecial;
import com.midian.base.util.UIHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页tab选项
 * Created by WeiQingFeng on 2017/4/20.
 */

public class AdapterGridGoodType extends BaseAdapter {

    private Context context;
    private String[] s={"热销榜","进口母婴","进口美妆","进口食品","全球站"};
    private Integer[] i={R.drawable.icon_home_tab1,R.drawable.icon_home_tab2,R.drawable.icon_home_tab3,R.drawable.icon_home_tab4,R.drawable.icon_home_tab5};
    private List<String> str = Arrays.asList(s);
    private List<Integer> pics = Arrays.asList(i);

    public AdapterGridGoodType(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridgoodtype, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(str.get(position));
        viewHolder.iv.setImageResource(pics.get(position));
        viewHolder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    UIHelper.jump((Activity) context, ActivityHotList.class);
                }else if(position==1 || position==2 || position==3){
                    UIHelper.jump((Activity) context, ActivitySpecial.class);
                }else{
                    UIHelper.jump((Activity) context, ActivityGlobal.class);
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.llItem)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
