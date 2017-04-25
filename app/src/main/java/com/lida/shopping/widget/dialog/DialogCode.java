package com.lida.shopping.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.lida.shopping.R;
import com.lida.shopping.activity.ActivitySpecial;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class DialogCode extends Dialog {


    @BindView(R.id.ivHead)
    RoundedImageView ivHead;
    @BindView(R.id.ivCode)
    ImageView ivCode;
    @BindView(R.id.btnSaceCode)
    Button btnSaceCode;
    @BindView(R.id.btnShare)
    Button btnShare;
    @BindView(R.id.ivClose)
    ImageView ivClose;
    private Context context;
    private String str;

    public DialogCode(Context context) {
        super(context, R.style.diy_dialog);
        init(context);
    }

    public DialogCode(Context context, int themeResId) {
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
        View v = View.inflate(context, R.layout.dialog_code, null);
        this.setContentView(v);
        ButterKnife.bind(this, v);
        setOnDismissListener(onDismissListener);
    }

    OnDismissListener onDismissListener = new OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
            ((Activity)context).finish();
        }
    };

    @OnClick({R.id.btnSaceCode, R.id.btnShare, R.id.ivClose})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSaceCode:
                break;
            case R.id.btnShare:
                break;
            case R.id.ivClose:
                break;
        }
        dismiss();
    }
}
