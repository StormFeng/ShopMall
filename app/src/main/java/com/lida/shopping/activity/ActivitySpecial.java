package com.lida.shopping.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterActivitySpecial;
import com.lida.shopping.widget.inner.InnerGridView;
import com.midian.base.base.BaseActivity;
import com.midian.base.util.UIHelper;
import com.midian.base.widget.BaseLibTopbarView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 店主专享
 * Created by WeiQingFeng on 2017/4/24.
 */

public class ActivitySpecial extends BaseActivity {
    @BindView(R.id.ivTop)
    ImageView ivTop;
    @BindView(R.id.gridView)
    InnerGridView gridView;
    @BindView(R.id.topbar)
    BaseLibTopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        ButterKnife.bind(this);
        topbar.setTitle("店主专享");
        topbar.setLeftImageButton(R.drawable.icon_back, UIHelper.finish(_activity));
        gridView.setAdapter(new AdapterActivitySpecial(_activity));
    }
}
