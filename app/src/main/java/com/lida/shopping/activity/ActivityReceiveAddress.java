package com.lida.shopping.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lida.shopping.R;
import com.lida.shopping.data.ActivityReceiveAddressData;
import com.lida.shopping.tpl.ActivityReceiveAddressTpl;
import com.midian.base.base.BaseListActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

/**
 * 收货地址
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityReceiveAddress extends BaseListActivity{

    private BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topbar = (BaseLibTopbarView)findViewById(R.id.topbar);
        topbar.setTitle("收货地址");
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
}
