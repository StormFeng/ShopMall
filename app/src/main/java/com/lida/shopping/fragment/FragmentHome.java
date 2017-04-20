package com.lida.shopping.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.lida.shopping.adapter.Adapter;
import com.lida.shopping.adapter.AdapterGridBot;
import com.lida.shopping.adapter.AdapterGridGoodType;
import com.lida.shopping.adapter.AdapterGridTime;
import com.lida.shopping.adapter.AdapterHListView;
import com.lida.shopping.adapter.AdapterHomeHarryBay;
import com.lida.shopping.widget.HorizontalListView;
import com.lida.shopping.widget.inner.InnerGridView;
import com.lida.shopping.widget.inner.InnerListView;
import com.lida.shopping.widget.inner.InnerViewPager;
import com.midian.base.base.BaseFragment;
import com.midian.base.util.Func;
import com.midian.base.widget.Banner;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.DummyPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentHome extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.gridType)
    InnerGridView gridType;
    @BindView(R.id.gridTime)
    InnerGridView gridTime;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewPager)
    InnerViewPager viewPager;
    @BindView(R.id.hListView)
    HorizontalListView hListView;
    @BindView(R.id.gridBot)
    InnerGridView gridBot;

    private List<Integer> images = new ArrayList<>();
    private List<Boolean> status=new ArrayList<>();
    private AdapterGridTime adapterGridTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initMagicIndicator(view);
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
        adapterGridTime=new AdapterGridTime(_activity,status);
        adapterGridTime.setOnTimeChangeListener(onTimeChangeListener);
        gridTime.setAdapter(adapterGridTime);
        List<View> views = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            InnerListView view = new InnerListView(_activity);
            view.setAdapter(new AdapterHomeHarryBay(_activity, i));
            views.add(view);
        }
        viewPager.setAdapter(new Adapter(views));
        viewPager.setOnPageChangeListener(onPageChangeListener);
        hListView.setAdapter(new AdapterHListView(_activity));
        gridBot.setAdapter(new AdapterGridBot(_activity));
    }

    AdapterGridTime.OnTimeChangeListener onTimeChangeListener = new AdapterGridTime.OnTimeChangeListener() {
        @Override
        public void changePage(int position) {
            viewPager.setCurrentItem(position);
        }
    };

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            for (int j = 0; j < 4; j++) {
                status.set(j,true);
            }
            status.set(i,false);
            adapterGridTime.notifyDataSetChanged();
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void initMagicIndicator(View view) {
        MagicIndicator magicIndicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(_activity);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                return new DummyPagerTitleView(context);
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setLineHeight(Func.Dp2Px(_activity, 3));
                indicator.setColors(Color.parseColor("#EB1712"));
                return indicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                return 1.0f;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
