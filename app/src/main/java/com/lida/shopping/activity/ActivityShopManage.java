package com.lida.shopping.activity;

import android.os.Bundle;

import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 店铺管理
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityShopManage extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopmanege);
        ButterKnife.bind(this);
        topbar = (BaseLibTopbarView)findViewById(R.id.topbar);
        topbar.setTitle("店铺管理");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }
}
