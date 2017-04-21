package com.lida.shopping.activity;

import android.os.Bundle;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterActivitySuggest;
import com.lida.shopping.widget.inner.InnerGridView;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 意见反馈
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivitySuggest extends BaseActivity {
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;
    @BindView(R.id.gvProblem)
    InnerGridView gvProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        ButterKnife.bind(this);
        topbar.setTitle("意见反馈");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        gvProblem.setAdapter(new AdapterActivitySuggest(_activity));
    }
}
