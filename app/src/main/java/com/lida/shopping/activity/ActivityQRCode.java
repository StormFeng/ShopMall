package com.lida.shopping.activity;

import android.os.Bundle;

import com.lida.shopping.R;
import com.lida.shopping.widget.dialog.DialogCode;
import com.lida.shopping.widget.dialog.DialogCode2;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的二维码
 * Created by WeiQingFeng on 2017/4/25.
 */

public class ActivityQRCode extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        ButterKnife.bind(this);
        topbar.setTitle("我的二维码");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        new DialogCode(_activity).show();
        new DialogCode2(_activity).show();
    }
}
