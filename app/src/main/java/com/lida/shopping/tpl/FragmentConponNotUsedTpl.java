package com.lida.shopping.tpl;

import android.content.Context;
import android.util.AttributeSet;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterInnerBooks;
import com.lida.shopping.widget.inner.InnerListView;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 优惠券-未使用
 * Created by WeiQingFeng on 2017/4/21.
 */

public class FragmentConponNotUsedTpl extends BaseTpl {

    public FragmentConponNotUsedTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentConponNotUsedTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_fragmentcouponlist;
    }

    @Override
    public void setBean(NetResult bean, int position) {
    }
}
