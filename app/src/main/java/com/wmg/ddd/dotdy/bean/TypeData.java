package com.wmg.ddd.dotdy.bean;

import com.wmg.ddd.dotdy.bean.idata.IRegularData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 明光 on 2017/10/25.
 */
@Entity
public class TypeData implements IRegularData {

    @Id
    private String id;

    @Property
    /**
     * 数据的类别
     * 0-今事今毕 1-贵在坚持 3-心情随笔
     */
    private int type;

    /**
     * 类别的主题，同type中的描述
     */
    private String theme;

    /**
     * 用户自定义主题
     */
    private String defTheme;

    /**
     * 主题对应的相关描述
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

    @Generated(hash = 1904715943)
    public TypeData(String id, int type, String theme, String defTheme, String des,
            long createTime, long updateTime, String icon, String orgIcon) {
        this.id = id;
        this.type = type;
        this.theme = theme;
        this.defTheme = defTheme;
        this.des = des;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.icon = icon;
        this.orgIcon = orgIcon;
    }

    @Generated(hash = 155981510)
    public TypeData() {
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String getTheme() {
        return theme;
    }

    @Override
    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String getDes() {
        return des;
    }

    @Override
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public long getCreateTime() {
        return createTime;
    }

    @Override
    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public long getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDefTheme() {
        return defTheme;
    }

    public void setDefTheme(String defTheme) {
        this.defTheme = defTheme;
    }

    @Override
    public String getOrgIcon() {
        return orgIcon;
    }

    @Override
    public void setOrgIcon(String orgIcon) {
        this.orgIcon = orgIcon;
    }
}
