package com.baiiu.zhihudaily.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baiiu.zhihudaily.R;
import com.baiiu.zhihudaily.view.SwipeBackLayout;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by baiiu on 15/11/16.
 * Base
 */
public abstract class BaseActivity extends RxAppCompatActivity implements SwipeBackLayout.SwipeBackListener {

    @Nullable @BindView(R.id.toolbar) public Toolbar mTtoolbar;
    protected ActionBar actionBar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());

        ButterKnife.bind(this);

        if (mTtoolbar != null) {
            setSupportActionBar(mTtoolbar);

            actionBar = getSupportActionBar();

            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(canSwipeBack);
                initActionBar(actionBar);
            }
        }

        initOnCreate(savedInstanceState);
    }

    public abstract int provideLayoutId();

    protected void initActionBar(ActionBar actionBar) {
    }

    protected abstract void initOnCreate(Bundle savedInstanceState);

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }

    //===============================swipeBack,在ProvideLayoutId前调用==============================================
    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;
    private boolean canSwipeBack = false;

    public void setCanSwipeBack(boolean canSwipeBack) {
        this.canSwipeBack = canSwipeBack;
    }

    @Override public void setContentView(int layoutResID) {
        if (canSwipeBack) {
            super.setContentView(getContainer());
            View view = LayoutInflater.from(this)
                    .inflate(layoutResID, null);
            swipeBackLayout.addView(view);
        } else {
            super.setContentView(layoutResID);
        }
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(this);
        swipeBackLayout = new SwipeBackLayout(this);
        swipeBackLayout.setOnSwipeBackListener(this);
        ivShadow = new ImageView(this);
        ivShadow.setBackgroundColor(getResources().getColor(R.color.black_p50));
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                                                RelativeLayout.LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        return container;
    }

    @Override public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
        ivShadow.setAlpha(1 - fractionScreen);
    }
}
