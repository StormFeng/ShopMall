package com.lida.shopping.activity;

import android.os.Bundle;
import android.view.View;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterActivityBookConfirm;
import com.lida.shopping.widget.inner.InnerGridView;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单确认
 * Created by WeiQingFeng on 2017/4/24.
 */

public class ActivityBookConfirm extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.lvGood)
    InnerGridView lvGood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookconfirm);
        ButterKnife.bind(this);
        topbar.setTitle("订单确认");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        lvGood.setAdapter(new AdapterActivityBookConfirm(_activity));
    }

    @OnClick({R.id.tvAddAddress, R.id.btnSettlement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvAddAddress:
                UIHelper.jump(_activity,ActivityReceiveAddress.class);
                break;
            case R.id.btnSettlement:
                break;
        }
    }
}
