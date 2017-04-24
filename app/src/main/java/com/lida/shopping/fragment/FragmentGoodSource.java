package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterFragmentGoodSource;
import com.lida.shopping.widget.inner.InnerGridView;
import com.midian.base.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 商品素材
 * Created by WeiQingFeng on 2017/4/24.
 */

public class FragmentGoodSource extends BaseFragment {
    @BindView(R.id.gvGood)
    InnerGridView gvGood;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_goodsource, null);
        unbinder = ButterKnife.bind(this, v);
        gvGood.setAdapter(new AdapterFragmentGoodSource(_activity));
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
