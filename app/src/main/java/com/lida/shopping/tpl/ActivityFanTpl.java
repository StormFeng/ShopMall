package com.lida.shopping.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.lida.shopping.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

/**
 * 粉丝达人
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityFanTpl extends BaseTpl {

    public ActivityFanTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityFanTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_activityfan;
    }

    @Override
    public void setBean(NetResult bean, int position) {

    }
}
