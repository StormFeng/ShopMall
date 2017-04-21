package com.lida.shopping.data;

import android.content.Context;

import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;

/**
 *粉丝达人
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityFanData extends BaseListDataSource {

    public ActivityFanData(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        ArrayList<NetResult> models = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            models.add(new NetResult());
        }
        hasMore=false;
        return models;
    }
}
