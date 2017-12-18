package com.wmg.ddd.dotdy.dao.typedata;

import com.wmg.ddd.dotdy.bean.idata.IRegularData;
import com.wmg.ddd.dotdy.dao.idao.IModifyData;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by wu-mingguang on 2017/12/18.
 */

public interface IModifyTypeData extends IModifyData {
    Observable<Boolean> modifyData(IRegularData data);

    Observable<Boolean> modifyDatas(List<IRegularData> datas);
}
