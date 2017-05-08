package com.lida.shopping.login;

import android.os.Bundle;

import com.lida.shopping.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitationcode);
        ButterKnife.bind(this);
        topbar.setTitle("邀请码");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(this));
    }

    @OnClick(R.id.btnConfirm)
    public void onViewClicked() {
        UIHelper.jump(_activity, ActivityLogin.class);
    }
}
