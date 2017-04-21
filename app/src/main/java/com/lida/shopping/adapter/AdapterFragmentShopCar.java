package com.lida.shopping.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.apkfuns.logutils.LogUtils;
import com.lida.shopping.R;
import com.lida.shopping.bean.FragmentShopCarBean;
import com.lida.shopping.widget.NumberWidget;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WeiQingFeng on 2017/4/21.
 */

public class AdapterFragmentShopCar extends BaseExpandableListAdapter {

    private Context context;
    private FragmentShopCarBean data;
    private OnSelectChangeListener onSelectChangeListener;

    public AdapterFragmentShopCar(Context context, FragmentShopCarBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.getContent().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.getContent().get(groupPosition).getPChild().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.getContent().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.getContent().get(groupPosition).getPChild().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final PViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopcar_parent, null);
            viewHolder=new PViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (PViewHolder) convertView.getTag();
        }
        if(data.getContent().get(groupPosition).ispSelect()){
            viewHolder.pCb.setChecked(true);
        }else{
            viewHolder.pCb.setChecked(false);
        }
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.tvEdit:
                        if(data.getContent().get(groupPosition).ispEdit()){
                            viewHolder.tvEdit.setText("编辑");
                            data.getContent().get(groupPosition).setpEdit(false);
                            for (int i = 0; i < data.getContent().get(groupPosition).getPChild().size(); i++) {
                                data.getContent().get(groupPosition).getPChild().get(i).setcEdit(false);
                            }
                        }else{
                            viewHolder.tvEdit.setText("完成");
                            data.getContent().get(groupPosition).setpEdit(true);
                            for (int i = 0; i < data.getContent().get(groupPosition).getPChild().size(); i++) {
                                data.getContent().get(groupPosition).getPChild().get(i).setcEdit(true);
                            }
                        }
                        notifyDataSetChanged();
                        break;
                    case R.id.pCb:
                        if(data.getContent().get(groupPosition).ispSelect()){
                            data.getContent().get(groupPosition).setpSelect(false);
                        }else{
                            data.getContent().get(groupPosition).setpSelect(true);
                        }
                        break;
                }
            }
        };
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (int i = 0; i < data.getContent().get(groupPosition).getPChild().size(); i++) {
                    data.getContent().get(groupPosition).getPChild().get(i).setcSelect(isChecked);
                }
                notifyDataSetChanged();
            }
        };
        viewHolder.pCb.setOnCheckedChangeListener(onCheckedChangeListener);
        viewHolder.tvEdit.setOnClickListener(listener);
        viewHolder.pCb.setOnClickListener(listener);
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final CViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopcar_child, null);
            viewHolder=new CViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (CViewHolder) convertView.getTag();
        }
        if(data.getContent().get(groupPosition).getPChild().get(childPosition).iscEdit()){
            viewHolder.etNumber.setVisibility(View.VISIBLE);
            viewHolder.btnDelete.setVisibility(View.VISIBLE);
            viewHolder.tvGoodName.setVisibility(View.GONE);
            viewHolder.tvNumber.setVisibility(View.GONE);
        }else{
            viewHolder.etNumber.setVisibility(View.GONE);
            viewHolder.btnDelete.setVisibility(View.GONE);
            viewHolder.tvGoodName.setVisibility(View.VISIBLE);
            viewHolder.tvNumber.setVisibility(View.VISIBLE);
        }
        if(data.getContent().get(groupPosition).getPChild().get(childPosition).iscSelect()){
            viewHolder.cCb.setChecked(true);
        }else{
            viewHolder.cCb.setChecked(false);
        }
        viewHolder.etNumber.setOnNumberChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewHolder.tvNumber.setText(s);
            }
        });
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.getContent().get(groupPosition).getPChild().get(childPosition).setcSelect(isChecked);

                List<Boolean> temp = new ArrayList<>();
                for (int i = 0; i < data.getContent().get(groupPosition).getPChild().size(); i++) {
                    temp.add(data.getContent().get(groupPosition).getPChild().get(i).iscSelect());
                }
                if(temp.contains(false)){
                    data.getContent().get(groupPosition).setpSelect(false);
                }else{
                    data.getContent().get(groupPosition).setpSelect(true);
                }

                List<Boolean> allTemp = new ArrayList<>();
                for (int i = 0; i < data.getContent().size(); i++) {
                    allTemp.add(data.getContent().get(i).ispSelect());
                }
                if(allTemp.contains(false)){
                    onSelectChangeListener.onPItemChanged(false);
                }else{
                    onSelectChangeListener.onPItemChanged(true);
                }

                notifyDataSetChanged();
            }
        };
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnDelete:
                        data.getContent().get(groupPosition).getPChild().remove(childPosition);
                        notifyDataSetChanged();
                        break;
                }
            }
        };
        viewHolder.btnDelete.setOnClickListener(listener);
        viewHolder.cCb.setOnCheckedChangeListener(onCheckedChangeListener);
        return convertView;
    }

    public void setOnSelectChangeListener(OnSelectChangeListener onSelectChangeListener){
        this.onSelectChangeListener = onSelectChangeListener;
    }
    public interface OnSelectChangeListener{
        void onPItemChanged(boolean isSelectAll);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class CViewHolder {
        @BindView(R.id.cCb)
        CheckBox cCb;
        @BindView(R.id.ivGood)
        ImageView ivGood;
        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvGoodName)
        TextView tvGoodName;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvNumber)
        TextView tvNumber;
        @BindView(R.id.etNumber)
        NumberWidget etNumber;
        @BindView(R.id.btnDelete)
        Button btnDelete;
        @BindView(R.id.llCItem)
        LinearLayout llCItem;

        CViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class PViewHolder {
        @BindView(R.id.pCb)
        CheckBox pCb;
        @BindView(R.id.tvShopName)
        TextView tvShopName;
        @BindView(R.id.tvGetCoupon)
        TextView tvGetCoupon;
        @BindView(R.id.tvEdit)
        TextView tvEdit;
        @BindView(R.id.llPCB)
        LinearLayout llPCB;

        PViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
