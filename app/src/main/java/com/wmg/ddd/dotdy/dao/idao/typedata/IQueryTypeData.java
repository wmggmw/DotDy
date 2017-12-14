package com.wmg.ddd.dotdy.dao.idao.typedata;

import com.wmg.ddd.dotdy.bean.TypeData;

import java.util.List;

/**
 * Created by 明光 on 2017/12/12.
 */

public interface IQueryTypeData {

    List<TypeData> queryAll();

    TypeData queryById();
}
