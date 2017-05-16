package com.lida.shopping.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lida.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收不到验证码？
 * Created by Administrator on 2016/10/28 0028.
 */

public class DialogCantReceiveCode extends Dialog {

    @BindView(R.id.ivClose)
    ImageView ivClose;
    private Context context;

    public DialogCantReceiveCode(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public DialogCantReceiveCode(Context context, int themeResId) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        Window w = this.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        w.setAttributes(lp);
        this.setCanceledOnTouchOutside(true);
        View v = View.inflate(context, R.layout.dialog_cantreceivecode, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
    }

    @OnClick(R.id.ivClose)
    public void onViewClicked() {
        dismiss();
    }
}
