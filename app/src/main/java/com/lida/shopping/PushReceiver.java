package com.lida.shopping;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.baidu.android.pushservice.PushMessageReceiver;
import com.lida.shopping.activity.ActivityBooks;
import com.lida.shopping.activity.ActivityFan;
import com.lida.shopping.activity.ActivityFreeOpenShop;
import com.lida.shopping.login.ActivityInvitationCode;
import com.lida.shopping.login.ActivityLogin;
import com.midian.base.util.UIHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by WeiQingFeng on 2017/5/16.
 */

public class PushReceiver extends PushMessageReceiver {

    private int requestCode = 1;//推送请求参数


    @Override
    public void onBind(Context context, int errorCode, String appid, String userId, String channelId, String requestId) {
        Log.d(TAG, "onBind");
        String responseString = "onBind errorCode=" + errorCode + " appid=" + appid + " userId=" + userId + " channelId=" + channelId
                + " requestId=" + requestId;
        Log.d(TAG, responseString);
        System.out.println("onBind绑定成功" + responseString);
        if (errorCode == 0) {
            // 绑定成功
//            ac.saveDeviceToken(channelId);
            System.out.println("百度云推送绑定成功;:::channelId=" + channelId);
        }
    }

    @Override
    public void onUnbind(Context context, int i, String s) {

    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {

    }

    @Override
    public void onMessage(Context context, String message, String customContentString) {
        String messageString = "透传消息 message=\"" + message
                + "\" customContentString=" + customContentString;
        Log.d(TAG, messageString);
        System.out.println("messageString" + messageString);
    }

    @Override
    public void onNotificationClicked(Context context, String title, String description, String customContentString) {
        String notifyString = "通知点击 title=\"" + title + "\" description=\""
                + description + "\" customContent=" + customContentString;
        Log.d(TAG, notifyString);
        System.out.println(notifyString);
        Intent intent = new Intent();
        intent.setClass(context.getApplicationContext(), ActivityFreeOpenShop.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(intent);
    }

    @Override
    public void onNotificationArrived(Context context, String s, String s1, String s2) {

    }
}
