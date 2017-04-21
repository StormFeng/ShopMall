package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterFragmentShopCar;
import com.lida.shopping.bean.FragmentShopCarBean;
import com.midian.base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 购物车
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentShopCar extends BaseFragment {

    @BindView(R.id.expandedList)
    ExpandableListView expandedList;
    Unbinder unbinder;
    @BindView(R.id.cbSelectAll)
    CheckBox cbSelectAll;
    @BindView(R.id.tvAllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tvExpress)
    TextView tvExpress;
    @BindView(R.id.btnCheckout)
    Button btnCheckout;

    private FragmentShopCarBean data;
    private AdapterFragmentShopCar adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopcar, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    AdapterFragmentShopCar.OnSelectChangeListener onSelectChangeListener=new AdapterFragmentShopCar.OnSelectChangeListener() {
        @Override
        public void onPItemChanged(boolean isSelectAll) {
            cbSelectAll.setChecked(isSelectAll);
        }
    };

    private void initView() {
        adapter = new AdapterFragmentShopCar(_activity, data);
        adapter.setOnSelectChangeListener(onSelectChangeListener);
        expandedList.setAdapter(adapter);
        expandedList.setGroupIndicator(null);
        for (int i = 0; i < data.getContent().size(); i++) {
            expandedList.expandGroup(i);
        }
        cbSelectAll.setOnClickListener(listener);
    }

    private void initData() {
        data = new FragmentShopCarBean();
        FragmentShopCarBean.ContentBean.PChildBean c1 = new FragmentShopCarBean.ContentBean.PChildBean();
        c1.setCName("美国爱尔邦尼天然儿童蜂蜜");
        c1.setCNumber("1");
        c1.setCPrice("288");
        c1.setcEdit(false);
        c1.setcSelect(false);
        c1.setcPic(R.drawable.temp_good1);

        FragmentShopCarBean.ContentBean.PChildBean c2 = new FragmentShopCarBean.ContentBean.PChildBean();
        c2.setCName("爱尔邦尼天然儿童蜂蜜");
        c2.setCNumber("3");
        c2.setCPrice("100");
        c2.setcEdit(false);
        c2.setcSelect(false);
        c2.setcPic(R.drawable.temp_good1);

        List<FragmentShopCarBean.ContentBean.PChildBean> list1 = new ArrayList<>();
        list1.add(c1);

        List<FragmentShopCarBean.ContentBean.PChildBean> list2 = new ArrayList<>();
        list2.add(c2);

        FragmentShopCarBean.ContentBean p1 = new FragmentShopCarBean.ContentBean();
        p1.setPChild(list1);
        p1.setPName("大小咖");
        p1.setpEdit(false);
        p1.setpSelect(false);

        FragmentShopCarBean.ContentBean p2 = new FragmentShopCarBean.ContentBean();
        p2.setPChild(list2);
        p2.setPName("大小咖");
        p2.setpEdit(false);
        p2.setpSelect(false);

        List<FragmentShopCarBean.ContentBean> list3 = new ArrayList<>();
        list3.add(p1);
        list3.add(p2);

        data.setContent(list3);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean checked = cbSelectAll.isChecked();
            if(checked){
                cbSelectAll.setChecked(false);
            }else{
                cbSelectAll.setChecked(true);
            }
            for (int i = 0; i < data.getContent().size(); i++) {
                data.getContent().get(i).setpSelect(checked);
            }
            adapter.notifyDataSetChanged();
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnCheckout)
    public void onViewClicked() {
    }
}
