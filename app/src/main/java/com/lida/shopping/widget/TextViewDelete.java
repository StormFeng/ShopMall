package com.lida.shopping.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.midian.base.util.Func;

/**
 * Created by WeiQingFeng on 2017/4/24.
 */

public class TextViewDelete extends android.support.v7.widget.AppCompatTextView {

    private Context context;

    public TextViewDelete(Context context) {
        super(context);
        this.context = context;
    }

    public TextViewDelete(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TextViewDelete(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(Func.Dp2Px(context,1));
        canvas.drawLine(0,getMeasuredHeight()/2,getMeasuredWidth(),getMeasuredHeight()/2,paint);
    }
}
