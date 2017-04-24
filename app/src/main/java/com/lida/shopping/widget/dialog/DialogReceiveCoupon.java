package com.lida.shopping.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.lida.shopping.R;
import com.lida.shopping.adapter.AdapterReceiveCoupon;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 领取优惠券
 * Created by Administrator on 2016/10/27 0027.
 */

public class DialogReceiveCoupon extends Dialog {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.btnClose)
    Button btnClose;
    private Context context;

    public DialogReceiveCoupon(Context context) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    public DialogReceiveCoupon(Context context, int themeResId) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_reveicecoupon, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
        listView.setAdapter(new AdapterReceiveCoupon(context));
    }

    @OnClick(R.id.btnClose)
    public void onViewClicked() {
        dismiss();
    }
}
