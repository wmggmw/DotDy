package com.wmg.ddd.dotdy.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wmg.ddd.dotdy.R;
import com.wmg.ddd.dotdy.entity.DaoMaster;
import com.wmg.ddd.dotdy.view.adapter.AddDataTypeAdapter;

import butterknife.BindView;

/**
 * Created by 明光 on 2017/10/24.
 */

public class AddDataTypeActivity extends AbstractActivity {
    @BindView(R.id.rv)
    RecyclerView vRv;

    private AddDataTypeAdapter mAdapter;

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_add_data_type;
    }

    @Override
    protected void initViewValues() {
        mAdapter = new AddDataTypeAdapter();
        vRv.setLayoutManager(new LinearLayoutManager(this));
        vRv.setAdapter(mAdapter);
    }

    public static void start(Context context){
        if( context == null)
            return;
        Intent starter = new Intent(context, AddDataTypeActivity.class);
        context.startActivity(starter);
    }
}
