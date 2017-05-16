package com.lida.shopping.login;

import android.os.Bundle;

import com.lida.shopping.MainActivity;
import com.lida.shopping.R;
import com.lida.shopping.activity.ActivityBuyGift;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 填写邀请码
 * Created by WeiQingFeng on 2017/5/8.
 */

public class ActivityInvitationCode extends BaseActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    private String from = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitationcode);
        ButterKnife.bind(this);
        from = mBundle.getString("from");
        topbar.setTitle("邀请码");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(this));
    }

    @OnClick(R.id.btnConfirm)
    public void onViewClicked() {
        if("ActivityFirstOpen".equals(from)){
            UIHelper.jump(_activity, MainActivity.class);
        }else{
            UIHelper.jump(_activity, ActivityBuyGift.class);
        }
    }
}
