package com.lida.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lida.shopping.R;
import com.lida.shopping.activity.ActivityAboutUs;
import com.lida.shopping.activity.ActivityBooks;
import com.lida.shopping.activity.ActivityCoupon;
import com.lida.shopping.activity.ActivityFan;
import com.lida.shopping.activity.ActivityGetMoney;
import com.lida.shopping.activity.ActivityMyInvitationCode;
import com.lida.shopping.activity.ActivityNoticeList;
import com.lida.shopping.activity.ActivityProblem;
import com.lida.shopping.activity.ActivityQRCode;
import com.lida.shopping.activity.ActivityReceiveAddress;
import com.lida.shopping.activity.ActivitySetting;
import com.lida.shopping.activity.ActivityShopManage;
import com.lida.shopping.activity.ActivitySpecial;
import com.lida.shopping.activity.ActivitySuggest;
import com.lida.shopping.data.ActivityFanData;
import com.midian.base.base.BaseFragment;
import com.midian.base.util.UIHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 我的
 * Created by WeiQingFeng on 2017/4/20.
 */

public class FragmentPersonal extends BaseFragment {

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvReadyPay, R.id.tvReadyDivider, R.id.tvAllBooks, R.id.tvMoney, R.id.tvGetMoney,
            R.id.tvCoupon, R.id.tvQRCode, R.id.tvAboutUs, R.id.tvReceiveAddress, R.id.tvSuggest,
            R.id.tvProblem, R.id.tvLookHistory, R.id.tvFan, R.id.tvSpecial, R.id.tvShopManage,
            R.id.tvInvitationCode, R.id.tvMyMessage})
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
            case R.id.tvMoney:
                break;
            case R.id.tvGetMoney:
                UIHelper.jump(_activity, ActivityGetMoney.class);
                break;
            case R.id.tvCoupon:
                UIHelper.jump(_activity, ActivityCoupon.class);
                break;
            case R.id.tvInvitationCode:
                UIHelper.jump(_activity, ActivityMyInvitationCode.class);
                break;
            case R.id.tvQRCode:
                UIHelper.jump(_activity, ActivityQRCode.class);
                break;
            case R.id.tvAboutUs:
                UIHelper.jump(_activity, ActivityAboutUs.class);
                break;
            case R.id.tvReceiveAddress:
                UIHelper.jump(_activity, ActivityReceiveAddress.class);
                break;
            case R.id.tvSetting:
                UIHelper.jump(_activity, ActivitySetting.class);
                break;
            case R.id.tvSuggest:
                UIHelper.jump(_activity, ActivitySuggest.class);
                break;
            case R.id.tvProblem:
                UIHelper.jump(_activity, ActivityProblem.class);
                break;
            case R.id.tvLookHistory:
                break;
            case R.id.tvFan:
                UIHelper.jump(_activity, ActivityFan.class);
                break;
            case R.id.tvSpecial:
                UIHelper.jump(_activity, ActivitySpecial.class);
                break;
            case R.id.tvShopManage:
                UIHelper.jump(_activity, ActivityShopManage.class);
                break;
            case R.id.tvMyMessage:
                UIHelper.jump(_activity, ActivityNoticeList.class);
                break;
        }
    }
}
