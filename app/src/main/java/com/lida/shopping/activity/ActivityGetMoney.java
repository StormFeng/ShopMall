package com.lida.shopping.activity;

import android.os.Bundle;

import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 申请提现
 * Created by WeiQingFeng on 2017/4/24.
 */

public class ActivityGetMoney extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getmoney);
        ButterKnife.bind(this);
        topbar.setTitle("申请提现");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }
}
