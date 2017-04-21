package com.lida.shopping.activity;

import android.os.Bundle;

import com.lida.shopping.R;
import com.lida.shopping.data.ActivityFanData;
import com.lida.shopping.tpl.ActivityFanTpl;
import com.midian.base.base.BaseListActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 粉丝达人
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityFan extends BaseListActivity {


    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        topbar = (BaseLibTopbarView)findViewById(R.id.topbar);
        topbar.setTitle("粉丝达人");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fan;
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityFanData(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityFanTpl.class;
    }
}
