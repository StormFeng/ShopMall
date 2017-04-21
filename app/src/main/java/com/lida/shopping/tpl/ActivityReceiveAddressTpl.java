package com.lida.shopping.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.lida.shopping.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

/**
 * 收货地址
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityReceiveAddressTpl extends BaseTpl {

    public ActivityReceiveAddressTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityReceiveAddressTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_activityreceiveaddress;
    }

    @Override
    public void setBean(NetResult bean, int position) {

    }
}
