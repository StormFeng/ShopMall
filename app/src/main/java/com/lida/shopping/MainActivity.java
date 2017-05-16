package com.lida.shopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.lida.shopping.fragment.FragmentClass;
import com.lida.shopping.fragment.FragmentHome;
import com.lida.shopping.fragment.FragmentPersonal;
import com.lida.shopping.fragment.FragmentPersonalNotBoss;
import com.lida.shopping.fragment.FragmentShopCar;
import com.lida.shopping.login.ActivityLogin;
import com.lida.shopping.util.SharedPreferencesUtils;
import com.midian.base.base.BaseFragmentActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.tvHome)
    TextView tvHome;
    @BindView(R.id.tvClass)
    TextView tvClass;
    @BindView(R.id.tvShopCar)
    TextView tvShopCar;
    @BindView(R.id.tvPersonal)
    TextView tvPersonal;
    @BindView(R.id.tvMain)
    TextView tvMain;
    @BindView(R.id.fragment)
    FrameLayout fragment;

    private long waitTime = 2000;
    private long touchTime = 0;
    private FragmentHome fragmentHome;
    private FragmentClass fragmentClass;
    private FragmentShopCar fragmentShopCar;
    private FragmentPersonal fragmentPersonal;
    private FragmentPersonalNotBoss fragmentPersonalNotBoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        topbar.setTitle("大小咖保税精品店");
        fragmentHome = new FragmentHome();
        fragmentClass = new FragmentClass();
        fragmentShopCar = new FragmentShopCar();
        fragmentPersonal = new FragmentPersonal();
        fragmentPersonalNotBoss = new FragmentPersonalNotBoss();
        switchFragment(fragmentHome);
    }

    @Override
    public int getFragmentContentId() {
        return R.id.fragment;
    }

    @OnClick({R.id.tvHome, R.id.tvClass, R.id.tvShopCar, R.id.tvPersonal, R.id.tvMain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvHome:
                setButton(R.id.tvHome);
                switchFragment(fragmentHome);
                break;
            case R.id.tvClass:
                setButton(R.id.tvClass);
                switchFragment(fragmentClass);
                break;
            case R.id.tvShopCar:
                setButton(R.id.tvShopCar);
                switchFragment(fragmentShopCar);
                break;
            case R.id.tvPersonal:
                boolean isFirst = (boolean) SharedPreferencesUtils.getParam(_activity,"isFirst",true);
                LogUtils.e(isFirst);
                if(isFirst){
                    Bundle bundle = new Bundle();
                    bundle.putString("from","MainActivity");
                    UIHelper.jumpForResult(_activity,ActivityLogin.class,bundle,1001);
                }else{
                    switchFragment(fragmentPersonalNotBoss);
                    setButton(R.id.tvPersonal);
                }
                break;
            case R.id.tvMain:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switchFragment(fragmentPersonal);
            setButton(R.id.tvPersonal);
            SharedPreferencesUtils.setParam(_activity,"isFirst",false);
        }
    }

    public void setButton(int id) {
        tvHome.setEnabled(true);
        tvClass.setEnabled(true);
        tvShopCar.setEnabled(true);
        tvPersonal.setEnabled(true);
        findViewById(id).setEnabled(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime - touchTime) >= waitTime) {
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                    touchTime = currentTime;
                } else {
                    finish();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
