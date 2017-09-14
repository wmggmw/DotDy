package com.wmg.ddd.dotdy.entity.base;

import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by wu-mingguang on 2017/9/14.
 */

public abstract class BaseEntry implements Comparable<BaseEntry>, Serializable{

    /**
     * ver 1.0.0
     */
    private static final long serialVersionUID = 4219110916298016827L;

    /**
     * id，格式为yyyyMMddhhmmdd+rand(4)
     */
    @Property
    private String id;

    /**
     * 描述
     */
    @Property
    private String des;

    /**
     * 起始时间
     */
    @Property
    private long startTime;

    /**
     * 结束时间
     */
    @Property
    private long endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
