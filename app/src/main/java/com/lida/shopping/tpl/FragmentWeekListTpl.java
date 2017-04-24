package com.lida.shopping.tpl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lida.shopping.R;
import com.midian.base.bean.NetResult;
import com.midian.base.view.BaseTpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 周排名TOP10
 * Created by WeiQingFeng on 2017/4/21.
 */

public class FragmentWeekListTpl extends BaseTpl {


    @BindView(R.id.tvOrder)
    TextView tvOrder;

    public FragmentWeekListTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentWeekListTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_top10list;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        tvOrder.setText(position+1+"");
    }
}
