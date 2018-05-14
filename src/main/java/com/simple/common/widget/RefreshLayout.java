package com.simple.common.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

public class RefreshLayout extends SmartRefreshLayout {

    private RecyclerView recyclerView;
    public RecyclerView.ItemDecoration itemDecoration;

    public RefreshLayout(Context context) {
        super(context);
        init();
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        itemDecoration = new HorizontalDividerItemDecoration.Builder(getContext())
                .build();
        recyclerView.addItemDecoration(itemDecoration);
        addView(recyclerView);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

}
