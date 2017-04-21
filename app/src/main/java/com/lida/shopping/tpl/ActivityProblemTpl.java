package com.lida.shopping.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.lida.shopping.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

/**
 * 常见问题
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityProblemTpl extends BaseTpl {

    public ActivityProblemTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityProblemTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_activityproblem;
    }

    @Override
    public void setBean(NetResult bean, int position) {

    }
}
