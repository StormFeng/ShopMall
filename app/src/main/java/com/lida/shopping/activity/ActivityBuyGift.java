package com.lida.shopping.activity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.CheckBox;

import com.lida.shopping.MainActivity;
import com.lida.shopping.R;
import com.lida.shopping.login.ActivityInvitationCode;
import com.midian.base.app.AppManager;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购买礼包
 * Created by WeiQingFeng on 2017/4/24.
 */

public class ActivityBuyGift extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.cb)
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buygift);
        ButterKnife.bind(this);
        topbar.setTitle("购买礼包");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }

    @OnClick(R.id.btnBuy)
    public void onViewClicked() {
        if(cb.isChecked()){
            UIHelper.t(_activity,"购买成功！");
            AppManager.getAppManager().finishActivity(MainActivity.class);
            AppManager.getAppManager().finishActivity(ActivityInvitationCode.class);
            UIHelper.jump(_activity, MainActivity.class);
            finish();
        }else{
            UIHelper.t(_activity,"请认真阅读《大小咖用户协议》");
        }
    }
}
