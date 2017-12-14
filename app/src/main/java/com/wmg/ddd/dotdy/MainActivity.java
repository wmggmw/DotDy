package com.wmg.ddd.dotdy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wmg.ddd.dotdy.bean.GoalData;
import com.wmg.ddd.dotdy.view.adapter.MItemTouchCallback;
import com.wmg.ddd.dotdy.view.adapter.MainAdapter;
import com.wmg.ddd.dotdy.widget.ReboundScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.subjects.AsyncSubject;

public class MainActivity extends Activity {
    @BindView(R.id.rv_main)
    RecyclerView recyclerView;
    @BindView(R.id.rsv_main)
    ReboundScrollView reboundScrollView;

    private MainAdapter adapter;
    private MItemTouchCallback itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///
        setContentView(R.layout.activity_simple_style);

        ButterKnife.bind(this);

        adapter = new MainAdapter();
        for(int i=0; i<20; i++){
            GoalData goalData = new GoalData();
            goalData.setId(""+i);
            goalData.setDes(i+""+i+""+i+""+i+""+i+"");
            adapter.addData(goalData);
        }

        itemTouchHelper = new MItemTouchCallback();
        itemTouchHelper.attachToRecyclerView(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        reboundScrollView.addRecyclerViewReachBottomListener(recyclerView, new ReboundScrollView.RecyclerViewCanScroll() {
            @Override
            public boolean canScroll(int direction) {
                return recyclerView.canScrollVertically(direction);
            }
        });
    }

    @OnClick(R.id.btn_select_catalog)
    public void clickOnSelectCatalog(View view){
        Observable.just("one", "two", "three", "four", "five")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<String>() {
                    @Override
                    public void onNext(@NonNull String s) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick(R.id.btn_show_more)
    public void clickOnShowMore(View view){

    }
}
