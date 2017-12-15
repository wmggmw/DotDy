package com.wmg.ddd.dotdy.bean;

import com.wmg.ddd.dotdy.bean.idata.IRegularData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 明光 on 2017/10/19.
 */

/**
 * 分步断点数据
 */
@Entity
public class StepBreakData implements IRegularData {

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
     * 中断点起始时间
     */
    private long startTime;
    /**
     * 中断点结束时间
     */
    private long endTime;
    /**
     * 中断原因
     */
    private String reason;
    /**
     * 中断恢复状态
     */
    private int stateAfterBreak;
    /**
     * 中断恢复描述
     * @return
     */
    private String desAfterBreak;
    @Generated(hash = 1962999374)
    public StepBreakData(String id, String theme, String des, long createTime,
            long updateTime, String icon, String orgIcon, long startTime,
            long endTime, String reason, int stateAfterBreak,
            String desAfterBreak) {
        this.id = id;
        this.theme = theme;
        this.des = des;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.icon = icon;
        this.orgIcon = orgIcon;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.stateAfterBreak = stateAfterBreak;
        this.desAfterBreak = desAfterBreak;
    }
    @Generated(hash = 718103270)
    public StepBreakData() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTheme() {
        return this.theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getDes() {
        return this.des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    public long getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getOrgIcon() {
        return this.orgIcon;
    }
    public void setOrgIcon(String orgIcon) {
        this.orgIcon = orgIcon;
    }
    public long getStartTime() {
        return this.startTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public long getEndTime() {
        return this.endTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public String getReason() {
        return this.reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public int getStateAfterBreak() {
        return this.stateAfterBreak;
    }
    public void setStateAfterBreak(int stateAfterBreak) {
        this.stateAfterBreak = stateAfterBreak;
    }
    public String getDesAfterBreak() {
        return this.desAfterBreak;
    }
    public void setDesAfterBreak(String desAfterBreak) {
        this.desAfterBreak = desAfterBreak;
    }
}
