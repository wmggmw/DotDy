package com.wmg.ddd.dotdy.bean;

import android.support.annotation.NonNull;

import com.wmg.ddd.dotdy.bean.idata.AbsData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 明光 on 2017/10/19.
 */

/**
 * 目标或计划分步数据
 */
@Entity
public class GoalStepData implements AbsData, Comparable<GoalStepData>{

    @Id
    /**
     * 唯一属性id
     */
    private String id;

    @Property
    /**
     * 数据主题
     */
    private String theme;

    /**
     * 数据基本描述
     */
    private String des;

    /**
     * 数据创建时间
     */
    private long createTime;

    /**
     * 数据最新更新时间
     */
    private long updateTime;

    /**
     * 特征图标或缩略图
     */
    private String icon;

    /**
     * 大图或原图地址
     */
    private String orgIcon;

    //非公共属性
    @Property
    /**
     * 是否结束 0-否 1-是
     */
    private int finished;
    /**
     * 一句话总结
     */
    private String summary;
    /**
     * 优先级
     * 0->1->2->3
     */
    private int priority;

    /**
     * 断点一数据id
     */
    private String break1Id;

    /**
     * 断点二数据id
     */
    private String break2Id;

    /**
     * 断点三数据id
     */
    private String break3Id;

    @Generated(hash = 2044831876)
    public GoalStepData(String id, String theme, String des, long createTime,
            long updateTime, String icon, String orgIcon, int finished,
            String summary, int priority, String break1Id, String break2Id,
            String break3Id) {
        this.id = id;
        this.theme = theme;
        this.des = des;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.icon = icon;
        this.orgIcon = orgIcon;
        this.finished = finished;
        this.summary = summary;
        this.priority = priority;
        this.break1Id = break1Id;
        this.break2Id = break2Id;
        this.break3Id = break3Id;
    }

    @Generated(hash = 946974188)
    public GoalStepData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getOrgIcon() {
        return orgIcon;
    }

    public void setOrgIcon(String orgIcon) {
        this.orgIcon = orgIcon;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getBreak1Id() {
        return break1Id;
    }

    public void setBreak1Id(String break1Id) {
        this.break1Id = break1Id;
    }

    public String getBreak2Id() {
        return break2Id;
    }

    public void setBreak2Id(String break2Id) {
        this.break2Id = break2Id;
    }

    public String getBreak3Id() {
        return break3Id;
    }

    public void setBreak3Id(String break3Id) {
        this.break3Id = break3Id;
    }

    @Override
    public int compareTo(@NonNull GoalStepData o) {
        return (int)(o.createTime-this.createTime);
    }

    public int getFinished() {
        return this.finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
