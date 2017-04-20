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
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentShopCar extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.gridType)
    InnerGridView gridType;
    @BindView(R.id.gridTime)
    InnerGridView gridTime;

    private List<Integer> images = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        for (int i = 0; i < 3; i++) {
            images.add(R.drawable.icon_banner);
        }
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(5000);//设置轮播间隔时间
        banner.setImages(images.toArray());
        gridType.setAdapter(new AdapterGridGoodType(_activity));
//        gridTime.setAdapter(new AdapterGridTime(_activity));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
