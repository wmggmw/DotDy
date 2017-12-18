package com.wmg.ddd.dotdy.dao.typedata;

import com.wmg.ddd.dotdy.bean.TypeData;
import com.wmg.ddd.dotdy.dao.idao.IGetData;

import java.util.List;

import io.reactivex.Observable;

/**
 * 网络请求，TypeData GET操作
 * Created by 明光 on 2017/12/12.
 */

public interface IGetTypeData extends IGetData {

    Observable<List<TypeData>> getAll();

    Observable<TypeData> getById();
}
