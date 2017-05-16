package com.lida.shopping.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 新增地址
 * Created by WeiQingFeng on 2017/4/24.
 */

public class ActivityAddAddress extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaddress);
        ButterKnife.bind(this);
        topbar.setTitle("收货地址");
        topbar.setLeftImageButton(R.drawable.icon_back,UIHelper.finish(_activity));
    }

    @OnClick(R.id.btnSaveAddress)
    public void onViewClicked() {
        UIHelper.t(_activity,"地址保存成功！");
        finish();
    }
}
