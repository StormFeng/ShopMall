package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lida.shopping.R;
import com.lida.shopping.activity.ActivityAboutUs;
import com.lida.shopping.activity.ActivityBooks;
import com.lida.shopping.activity.ActivityCoupon;
import com.lida.shopping.activity.ActivityProblem;
import com.lida.shopping.activity.ActivityReceiveAddress;
import com.lida.shopping.activity.ActivitySuggest;
import com.midian.base.base.BaseFragment;
import com.midian.base.util.UIHelper;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 我的(不是店主)
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentPersonalNotBoss extends BaseFragment {

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_notboss, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvReadyPay, R.id.tvReadyDivider, R.id.tvAllBooks, R.id.tvCoupon, R.id.tvWantShop,
            R.id.tvLookHistory, R.id.tvSuggest, R.id.tvSetting, R.id.tvProblem, R.id.tvReceiveAddress,
            R.id.tvAboutUs, R.id.tvDownLoadApp})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.tvReadyPay:
                bundle.putInt("position",0);
                UIHelper.jump(_activity, ActivityBooks.class,bundle);
                break;
            case R.id.tvReadyDivider:
                bundle.putInt("position",1);
                UIHelper.jump(_activity, ActivityBooks.class,bundle);
                break;
            case R.id.tvAllBooks:
                bundle.putInt("position",2);
                UIHelper.jump(_activity, ActivityBooks.class,bundle);
                break;
            case R.id.tvCoupon:
                UIHelper.jump(_activity, ActivityCoupon.class);
                break;
            case R.id.tvWantShop:
                break;
            case R.id.tvLookHistory:
                break;
            case R.id.tvSuggest:
                UIHelper.jump(_activity, ActivitySuggest.class);
                break;
            case R.id.tvSetting:
                break;
            case R.id.tvProblem:
                UIHelper.jump(_activity, ActivityProblem.class);
                break;
            case R.id.tvReceiveAddress:
                UIHelper.jump(_activity, ActivityReceiveAddress.class);
                break;
            case R.id.tvAboutUs:
                UIHelper.jump(_activity, ActivityAboutUs.class);
                break;
            case R.id.tvDownLoadApp:
                break;
        }
    }
}
