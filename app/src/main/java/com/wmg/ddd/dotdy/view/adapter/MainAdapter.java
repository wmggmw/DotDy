package com.wmg.ddd.dotdy.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wmg.ddd.dotdy.R;
import com.wmg.ddd.dotdy.bean.GoalData;
import com.wmg.ddd.dotdy.bean.idata.IRegularData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

public class MainAdapter<T extends IRegularData> extends BaseAdapter<T, MainAdapter.MainViewHolder> {

    public MainAdapter() {

    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainViewHolder holder, int position) {
        T data = getData(position);
        if( data instanceof GoalData){
            GoalData tData = (GoalData)data;
            holder.tvContent.setText(tData.getDes());
        }
    }

    @Override
    public int getItemCount() {
        return getCount();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_vh_content)
        TextView tvContent;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
