package com.lida.shopping.app;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.midian.base.app.AppContext;
import com.midian.base.util.ShareUtil;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class BaseAppContext extends AppContext {

    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtil.init();
//        ZXingLibrary.initDisplayOpinion(this);
        startPush();
    }

    /**
     * 启动推送
     */
    public void startPush() {
        System.out.println("startWork---启动推送");
        PushManager.startWork(this, PushConstants.LOGIN_TYPE_API_KEY, "qaFRGUy63ax6w0QQh8lyO2Lx");
    }

    /**
     * 停用推送
     */
    public void stopPush() {
        System.out.println("stopPush");
        PushManager.stopWork(getApplicationContext());
    }

    public void changePush() {
        if (isClosePush) {
            stopPush();
        } else {
            PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "qaFRGUy63ax6w0QQh8lyO2Lx");
        }
    }

}
