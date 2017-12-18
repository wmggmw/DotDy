package com.wmg.ddd.dotdy.dao.typedata;

import com.wmg.ddd.dotdy.bean.TypeData;
import com.wmg.ddd.dotdy.dao.idao.IQueryData;

import java.util.List;

import io.reactivex.Observable;

/**
 * 本地操作，TypeData 数据库查询
 * Created by 明光 on 2017/12/12.
 */

public interface IQueryTypeData extends IQueryData {

    Observable<List<TypeData>> queryAll();

    Observable<TypeData> queryById();
}
