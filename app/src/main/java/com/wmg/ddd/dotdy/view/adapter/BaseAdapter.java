package com.wmg.ddd.dotdy.view.adapter;

import android.support.v7.widget.RecyclerView;

import com.wmg.ddd.dotdy.bean.idata.AbsData;
import com.wmg.ddd.dotdy.exception.ArrayNullExeception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

public abstract class BaseAdapter<T extends AbsData, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> mDatas;

    public BaseAdapter() {
        this.mDatas = new ArrayList<>();
    }

    /**
     * 设置数据源
     * @param list
     */
    public void setDatas(List<T> list){
        if( list != null) {
            this.mDatas = list;
        }
    }

    /**
     * 增加单条数据
     * @param data
     */
    public void addData(T data){
        if( mDatas != null) {
            mDatas.add(data);
        }
    }

    /**
     * 增加多条数据
     * @param datas
     */
    public void addDatas(List<T> datas){
        if( mDatas != null){
            mDatas.addAll(datas);
        }
    }

    /**
     * 删除数据
     * @param data
     * @throws ArrayNullExeception
     */
    public void removeData(T data) throws ArrayNullExeception{
        if( mDatas == null) {
            throw new ArrayNullExeception("mDatas is null");
        }
        if( mDatas.isEmpty()){
            return;
        }
        if( mDatas.contains(data)){
            mDatas.remove(data);
            return;
        }
        for( T element: mDatas){
            if( data.getId().equals(element.getId())){
                mDatas.remove(element);
                return;
            }
        }
    }

    /**
     * 获取所有数据
     * @return
     */
    public List<T> getDatas(){
        return mDatas;
    }

    /**
     * 获取单条数据
     */
    public T getData(int position){
        if( mDatas == null || mDatas.size() < position){
            return null;
        }
        return mDatas.get(position);
    }

    public int getCount(){
        if( mDatas == null)
            return -1;
        return mDatas.size();
    }
}
