package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.midian.base.base.BaseFragment;

/**
 * 商品详情
 * Created by WeiQingFeng on 2017/4/24.
 */

public class FragmentGoodDetail extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gooddetail,null);
        return view;

    }
}
