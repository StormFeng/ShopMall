package com.lida.shopping.activity;

import android.graphics.Color;
import android.os.Bundle;

import com.lida.shopping.R;
import com.lida.shopping.data.ActivityNoticeListData;
import com.lida.shopping.tpl.ActivityNoticeTpl;
import com.midian.base.base.BaseListActivity;
import com.midian.base.util.Func;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 公告通知
 * Created by WeiQingFeng on 2017/5/8.
 */

public class ActivityNoticeList extends BaseListActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        listView.setPadding(Func.Dp2Px(_activity,20), 0, Func.Dp2Px(_activity,20), 0);
        listView.setBackgroundColor(Color.WHITE);
        topbar.setTitle("我的消息");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityNoticeListData(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityNoticeTpl.class;
    }
}
