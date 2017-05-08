package com.lida.shopping.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首次打开APP
 * Created by WeiQingFeng on 2017/5/8.
 */

public class ActivityFirstOpen extends BaseActivity {
    @BindView(R.id.btnPhoneLogin)
    Button btnPhoneLogin;
    @BindView(R.id.btnWeChatLogin)
    Button btnWeChatLogin;
    @BindView(R.id.cbXieYi)
    CheckBox cbXieYi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstopen);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnPhoneLogin, R.id.btnWeChatLogin})
    public void onViewClicked(View view) {
        if(cbXieYi.isChecked()){
            switch (view.getId()) {
                case R.id.btnPhoneLogin:
                    UIHelper.jump(_activity,ActivityInvitationCode.class);
                    break;
                case R.id.btnWeChatLogin:
                    break;
            }
        }else{
            UIHelper.t(_activity,"请认真阅读《大小咖用户协议》");
        }
    }
}
