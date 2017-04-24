package com.lida.shopping.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.lida.shopping.data.FragmentWeekListData;
import com.lida.shopping.tpl.FragmentWeekListTpl;
import com.midian.base.base.BaseListFragment;
import com.midian.base.util.Func;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

/**
 * 周排名TOP10
 * Created by WeiQingFeng on 2017/4/24.
 */

public class FragmentWeekList extends BaseListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        listView.setDivider(null);
        listView.setDividerHeight(Func.Dp2Px(_activity,10));
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_putorefreshlist;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new FragmentWeekListData(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return FragmentWeekListTpl.class;
    }
}
