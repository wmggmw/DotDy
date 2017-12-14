package com.wmg.ddd.dotdy.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wmg.ddd.dotdy.R;

import butterknife.BindView;

/**
 * Created by 明光 on 2017/10/24.
 */

public class AddDataTypeAdapter extends BaseAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AddDTViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_add_data_type, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class AddDTViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.btn)
        CheckBox vCb;
        @BindView(R.id.tv_type_name)
        TextView vTvTypeName;
        @BindView(R.id.tv_type_des)
        TextView vTvTypeDes;

        public AddDTViewHolder(View itemView) {
            super(itemView);
        }
    }
}
