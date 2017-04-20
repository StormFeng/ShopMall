package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterGridGoodType;
import com.lida.shopping.adapter.AdapterGridTime;
import com.lida.shopping.widget.inner.InnerGridView;
import com.midian.base.base.BaseFragment;
import com.midian.base.widget.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 我的
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentPersonal extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, null);
        return view;
    }
}
