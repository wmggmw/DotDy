package com.wmg.ddd.dotdy.bean;

import android.support.annotation.NonNull;

import com.wmg.ddd.dotdy.bean.idata.IRegularData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

/**
 * 目标或计划数据
 */
@Entity
public class GoalData implements IRegularData, Comparable<GoalData>{

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
    /**
     * 优先级
     * 0->1->2->3
     */
    private int priority;

    /**
     * 分步一数据id
     */
    private String step1Id;

    /**
     * 分步二数据id
     */
    private String step2Id;

    /**
     * 分步三数据id
     */
    private String step3Id;

    /**
     * 分步四数据id
     */
    private String step4Id;

    @Generated(hash = 1998140620)
    public GoalData(String id, String theme, String des, long createTime,
            long updateTime, String icon, String orgIcon, int priority,
            String step1Id, String step2Id, String step3Id, String step4Id) {
        this.id = id;
        this.theme = theme;
        this.des = des;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.icon = icon;
        this.orgIcon = orgIcon;
        this.priority = priority;
        this.step1Id = step1Id;
        this.step2Id = step2Id;
        this.step3Id = step3Id;
        this.step4Id = step4Id;
    }

    @Generated(hash = 1367654523)
    public GoalData() {
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
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStep1Id() {
        return this.step1Id;
    }

    public void setStep1Id(String step1Id) {
        this.step1Id = step1Id;
    }

    public String getStep2Id() {
        return this.step2Id;
    }

    public void setStep2Id(String step2Id) {
        this.step2Id = step2Id;
    }

    public String getStep3Id() {
        return this.step3Id;
    }

    public void setStep3Id(String step3Id) {
        this.step3Id = step3Id;
    }

    public String getStep4Id() {
        return this.step4Id;
    }

    public void setStep4Id(String step4Id) {
        this.step4Id = step4Id;
    }

    @Override
    public int compareTo(@NonNull GoalData o) {
        return (int)(o.createTime-this.createTime);
    }
}
