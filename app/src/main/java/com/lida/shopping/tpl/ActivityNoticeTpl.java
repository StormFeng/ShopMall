package com.lida.shopping.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.lida.shopping.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

/**
 * 公告通知
 * Created by WeiQingFeng on 2017/5/8.
 */

public class ActivityNoticeTpl extends BaseTpl {

    public ActivityNoticeTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityNoticeTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_activitynoticelist;
    }

    @Override
    public void setBean(NetResult bean, int position) {

    }
}
