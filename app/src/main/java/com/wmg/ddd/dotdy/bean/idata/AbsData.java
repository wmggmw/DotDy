package com.wmg.ddd.dotdy.bean.idata;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

public interface AbsData extends IData{

    void setId(String id);
    String getId();

    void setTheme(String theme);
    String getTheme();

    void setDes(String des);
    String getDes();

    void setCreateTime(long createTime);
    long getCreateTime();

    void setUpdateTime(long updateTime);
    long getUpdateTime();

    void setIcon(String icon);
    String getIcon();
}

