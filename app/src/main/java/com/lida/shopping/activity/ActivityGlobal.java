package com.lida.shopping.activity;

import android.os.Bundle;
import android.view.View;

import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 全球站
 * Created by WeiQingFeng on 2017/5/15.
 */

public class ActivityGlobal extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        ButterKnife.bind(this);
        topbar.setTitle("全球站");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }

    @OnClick({R.id.ivOuZhou, R.id.ivAoXin, R.id.ivMeiZhou, R.id.ivXinMaTai, R.id.ivGangTai, R.id.ivRiHan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivOuZhou:
                break;
            case R.id.ivAoXin:
                break;
            case R.id.ivMeiZhou:
                break;
            case R.id.ivXinMaTai:
                break;
            case R.id.ivGangTai:
                break;
            case R.id.ivRiHan:
                break;
        }
        UIHelper.jump(_activity,ActivitySpecial.class);
    }
}
