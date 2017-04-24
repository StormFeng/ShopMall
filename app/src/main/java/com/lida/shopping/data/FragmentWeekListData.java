package com.lida.shopping.data;

import android.content.Context;

import com.midian.base.base.BaseListDataSource;
import com.midian.base.bean.NetResult;

import java.util.ArrayList;

/**
 *周排名TOP10
 * Created by WeiQingFeng on 2017/4/21.
 */

public class FragmentWeekListData extends BaseListDataSource {

    public FragmentWeekListData(Context context) {
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
