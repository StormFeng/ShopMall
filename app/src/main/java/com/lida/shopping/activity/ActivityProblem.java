package com.lida.shopping.activity;

import android.os.Bundle;

import com.lida.shopping.R;
import com.lida.shopping.data.ActivityProblemData;
import com.lida.shopping.tpl.ActivityProblemTpl;
import com.midian.base.base.BaseListActivity;
import com.midian.base.widget.BaseLibTopbarView;
import com.midian.base.widget.pulltorefresh.listviewhelper.IDataSource;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 常见问题
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityProblem extends BaseListActivity {

    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected IDataSource<ArrayList> getDataSource() {
        return new ActivityProblemData(_activity);
    }

    @Override
    protected Class getTemplateClass() {
        return ActivityProblemTpl.class;
    }
}
