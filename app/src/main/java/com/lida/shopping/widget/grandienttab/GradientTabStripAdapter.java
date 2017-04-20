package com.lida.shopping.widget.grandienttab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;

import com.lida.shopping.R;

import java.util.ArrayList;
import java.util.List;

/**
 * GradientTabStripAdapter
 * Created by Alex on 2016/5/19.
 */
public class GradientTabStripAdapter extends FragmentPagerAdapter implements
        GradientTabStrip.GradientTabAdapter {

    private List<Fragment> fragments=new ArrayList<>();



    public GradientTabStripAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "工作台";
            case 1:
                return "个人中心";
        }
    }

    @Override
    public Drawable getNormalDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.icon_home_n);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.icon_class_n);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.icon_shopbag_n);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.icon_personal_n);
        }
    }

    @Override
    public Drawable getSelectedDrawable(int position, Context context) {
        switch (position) {
            default:
            case 0:
                return ContextCompat.getDrawable(context, R.drawable.icon_home_y);
            case 1:
                return ContextCompat.getDrawable(context, R.drawable.icon_class_y);
            case 2:
                return ContextCompat.getDrawable(context, R.drawable.icon_shopbag_y);
            case 3:
                return ContextCompat.getDrawable(context, R.drawable.icon_personal_y);
        }
    }

    @Override
    public boolean isTagEnable(int position) {
//        return position != 3;
        return false;
    }

    @Override
    public String getTag(int position)
    {
//        switch (position) {
//            default:
//            case 0:
//                return "888";
//            case 1:
//                return "";
//            case 2:
//                return "new";
//        }
        return "";
    }
}
