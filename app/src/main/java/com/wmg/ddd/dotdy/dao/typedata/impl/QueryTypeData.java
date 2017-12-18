package com.wmg.ddd.dotdy.dao.typedata.impl;

import com.wmg.ddd.dotdy.bean.TypeData;
import com.wmg.ddd.dotdy.dao.typedata.IQueryTypeData;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by wu-mingguang on 2017/12/18.
 */

public class QueryTypeData implements IQueryTypeData {

    @Override
    public Observable<List<TypeData>> queryAll() {
        return null;
    }

    @Override
    public Observable<TypeData> queryById() {
        return null;
    }
}
