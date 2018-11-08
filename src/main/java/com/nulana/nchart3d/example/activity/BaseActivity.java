package com.nulana.nchart3d.example.activity;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author catherine.brainwilliam
 * @since 2018/11/8
 */
public abstract class BaseActivity extends Activity {
    private Unbinder unbinder;
    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        getArgs(getIntent().getExtras());
        unbinder = ButterKnife.bind(this);
        activity = this;
        initViews();
        initListener();
    }

    protected abstract int getLayoutView();

    protected abstract void initViews();

    protected abstract void initListener();

    protected abstract void getArgs(Bundle bundle);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*解绑注解*/
        unbinder.unbind();
    }

}
