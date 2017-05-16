package com.lida.shopping.activity;

import android.os.Bundle;
import android.widget.Button;

import com.lida.shopping.R;
import com.lida.shopping.data.ActivityReceiveAddressData;
import com.lida.shopping.tpl.ActivityReceiveAddressTpl;
import com.midian.base.base.BaseListActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 地址管理
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityReceiveAddress extends BaseListActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.btnAddAddress)
    Button btnAddAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        topbar.setTitle("地址管理");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receiveaddress;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityReceiveAddressData(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityReceiveAddressTpl.class;
    }

    @OnClick(R.id.btnAddAddress)
    public void onViewClicked() {
        UIHelper.jump(_activity,ActivityAddAddress.class);
    }
}
