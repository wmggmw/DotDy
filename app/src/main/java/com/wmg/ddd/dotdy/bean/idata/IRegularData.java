package com.wmg.ddd.dotdy.bean.idata;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

public interface IRegularData extends IData{

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

    void setOrgIcon(String icon);
    String getOrgIcon();
}

