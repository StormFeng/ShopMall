package com.lida.shopping.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apkfuns.logutils.LogUtils;
import com.lida.shopping.MainActivity;
import com.lida.shopping.R;
import com.lida.shopping.widget.dialog.DialogCantReceiveCode;
import com.midian.base.base.BaseActivity;
import com.midian.base.bean.NetResult;
import com.midian.base.util.AnimatorUtils;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登陆页
 */
public class ActivityLogin extends BaseActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.btnCode)
    Button btnCode;

    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ac.isUserIdExsit()) {
            onDestroy();
            LogUtils.e(ac.isUserIdExsit());
        } else {
            setContentView(R.layout.activity_login);
            ButterKnife.bind(this);
            topbar.setTitle("手机登录");
            topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(this));
        }
    }

    @OnClick({R.id.btnCode, R.id.btn_login, R.id.tvCantReceiveCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnCode:
                UIHelper.t(_activity,"验证码发送成功！");
                downTime();
                break;
            case R.id.btn_login:
                String name = etName.getText().toString();
                String pass = etPass.getText().toString();
                String from = mBundle.getString("from");
                if("MainActivity".equals(from)){
                    setResult(RESULT_OK);
                    finish();
                }else{
                    UIHelper.jump(_activity,MainActivity.class);
                    finish();
                }
                break;
            case R.id.tvCantReceiveCode:
                new DialogCantReceiveCode(_activity).show();
                break;
        }
    }

    private void downTime() {
        mCountDownTimer = new CountDownTimer(59 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String timeText = "秒";
                btnCode.setEnabled(false);
                btnCode.setText(millisUntilFinished / 1000 + timeText);
            }

            @Override
            public void onFinish() {
                btnCode.setEnabled(true);
                btnCode.setText("验证码");
            }
        };
        mCountDownTimer.start();
    }

//    @OnClick(R.id.btn_login)
//    public void onClick() {
//        String name = etName.getText().toString();
//        String pass = etPass.getText().toString();
//        String from = mBundle.getString("from");
//        if("MainActivity".equals(from)){
//            setResult(RESULT_OK);
//            finish();
//        }else{
//            UIHelper.jump(_activity,MainActivity.class);
//        }
////        if("".equals(name)){
////            AnimatorUtils.onVibrationView(etName);
////            UIHelper.t(_activity,"请输入用户名");
////            return;
////        }
////        if("".equals(pass)){
////            AnimatorUtils.onVibrationView(etPass);
////            UIHelper.t(_activity,"请输入密码");
////            return;
////        }
////        AppUtil.getBikeApiClient(ac).login(name,pass,this);
//    }

    @Override
    public void onApiSuccess(NetResult res, String tag) {
        if (res.isOK()) {
//            LoginBean bean = (LoginBean) res;
//            ac.saveUserInfo(bean.getData().getId(),bean.getData().getName(),bean.getData().getHead_img(),bean.getData().getPhone(),
//                    bean.getData().getAddress(),bean.getData().getLogintime(),bean.getData().getAccount(),bean.getData().getPasswd(),
//                    bean.getData().getBirth(),bean.getData().getRepair_life());
//            UIHelper.t(_activity,"登录成功！");
//            UIHelper.jump(_activity,Activity_Main.class);
//            onDestroy();
        } else {
            AnimatorUtils.onVibrationView(btnLogin);
            UIHelper.t(_activity, "用户名或密码错误！");
        }
    }
}
