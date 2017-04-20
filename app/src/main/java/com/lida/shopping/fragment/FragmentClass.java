package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterFragmengClass;
import com.lida.shopping.adapter.AdapterTypeList;
import com.lida.shopping.widget.inner.InnerGridView;
import com.midian.base.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 分类
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentClass extends BaseFragment {

    @BindView(R.id.typeList)
    ListView typeList;
    Unbinder unbinder;
    @BindView(R.id.topGrid)
    InnerGridView topGrid;
    @BindView(R.id.botGrid)
    InnerGridView botGrid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, null);
        unbinder = ButterKnife.bind(this, view);
        typeList.setAdapter(new AdapterTypeList(_activity));
        typeList.setDivider(null);
        topGrid.setAdapter(new AdapterFragmengClass(_activity,8));
        botGrid.setAdapter(new AdapterFragmengClass(_activity,4));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
