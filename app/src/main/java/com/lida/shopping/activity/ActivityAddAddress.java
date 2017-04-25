package com.lida.shopping.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.lida.shopping.R;
import com.midian.base.base.BaseActivity;
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
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etCity)
    EditText etCity;
    @BindView(R.id.etStreet)
    EditText etStreet;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.btnSaveAddress)
    Button btnSaveAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaddress);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSaveAddress)
    public void onViewClicked() {
    }
}
