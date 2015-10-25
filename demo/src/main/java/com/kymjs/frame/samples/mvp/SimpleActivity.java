package com.kymjs.frame.samples.mvp;

import android.view.View;

import com.kymjs.frame.presenter.ActivityPresenter;
import com.kymjs.frame.samples.R;

/**
 * 在这里做业务逻辑操作，通过viewDelegate操作View层控件
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public class SimpleActivity extends ActivityPresenter<SimpleDelegate> implements View
        .OnClickListener {

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.get(R.id.button1).setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
//              也可以根据id得到这个控件(重复调用不会多次findview)
//              TextView tv = viewDelegate.get(R.id.helloword);
//              tv.setText("你点击了button");
                viewDelegate.setText("你点击了button");
                break;
        }
    }
}