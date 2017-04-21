package com.lida.shopping.data;

import android.content.Context;

import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;

/**
 *常见问题
 * Created by WeiQingFeng on 2017/4/21.
 */

public class ActivityProblemData extends BaseListDataSource {

    public ActivityProblemData(Context context) {
        super(context);
    }

    @Override
    protected ArrayList load(int page) throws Exception {
        ArrayList<NetResult> models = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            models.add(new NetResult());
        }
        hasMore=false;
        return models;
    }
}
