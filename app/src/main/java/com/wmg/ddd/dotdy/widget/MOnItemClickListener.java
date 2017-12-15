package com.wmg.ddd.dotdy.widget;

import android.view.View;

import com.wmg.ddd.dotdy.bean.idata.IRegularData;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

public interface MOnItemClickListener<T extends IRegularData> {
    void onItemClick(View view, T data, int position);

    void onItemLongClick(View view, T data, int position);
}
