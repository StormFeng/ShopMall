package com.lida.shopping.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.lida.shopping.data.FragmentConponNotUsedData;
import com.lida.shopping.tpl.FragmentConponNotUsedTpl;
import com.midian.base.base.BaseListFragment;
import com.midian.base.util.Func;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

/**
 * 优惠券-未使用
 * Created by WeiQingFeng on 2017/4/21.
 */

public class FragmentCouponNotUsed extends BaseListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        listView.setDivider(null);
        return v;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_putorefreshlist;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FragmentConponNotUsedData(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return FragmentConponNotUsedTpl.class;
    }
}
