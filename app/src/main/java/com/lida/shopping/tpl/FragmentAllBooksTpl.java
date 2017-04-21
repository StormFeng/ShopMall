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
 * 全部订单
 * Created by WeiQingFeng on 2017/4/21.
 */

public class FragmentAllBooksTpl extends BaseTpl {

    @BindView(R.id.innerList)
    InnerListView innerList;

    public FragmentAllBooksTpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FragmentAllBooksTpl(Context context) {
        super(context);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_books;
    }

    @Override
    public void setBean(NetResult bean, int position) {
        innerList.setAdapter(new AdapterInnerBooks(_activity,position+1));
    }
}
