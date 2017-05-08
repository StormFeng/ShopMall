package com.lida.shopping.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的邀请码
 * Created by WeiQingFeng on 2017/5/8.
 */

public class ActivityMyInvitationCode extends BaseActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tvInvitationCode)
    TextView tvInvitationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinvitationcode);
        ButterKnife.bind(this);
        topbar.setTitle("我的邀请码");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }

    @OnClick({R.id.tvInvitationCodeDetail, R.id.btnShare})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvInvitationCodeDetail:
                UIHelper.jump(_activity,ActivityInvitationDetail.class);
                break;
            case R.id.btnShare:
                break;
        }
    }
}
