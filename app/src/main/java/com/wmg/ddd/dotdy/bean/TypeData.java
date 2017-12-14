package com.wmg.ddd.dotdy.bean;

import com.wmg.ddd.dotdy.bean.idata.AbsData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 明光 on 2017/10/25.
 */
@Entity
public class TypeData {

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

    @Generated(hash = 833513446)
    public TypeData(int type, String theme, String defTheme, String des) {
        this.type = type;
        this.theme = theme;
        this.defTheme = defTheme;
        this.des = des;
    }

    @Generated(hash = 2135787902)
    public TypeData() {
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDefTheme() {
        return this.defTheme;
    }

    public void setDefTheme(String defTheme) {
        this.defTheme = defTheme;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
