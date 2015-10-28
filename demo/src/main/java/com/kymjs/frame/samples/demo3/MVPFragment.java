package com.kymjs.frame.samples.demo3;

import android.view.View;

import com.kymjs.frame.presenter.FragmentPresenter;
import com.kymjs.frame.samples.R;
import com.kymjs.frame.samples.demo1.SimpleDelegate;

/**
 * 这里就偷懒直接复用demo1里面的simpleDelegate视图代理了
 * 同样也说明了，我们可以不用做任何改变就把一个视图层的东西拿来复用
 *
 * @author kymjs (http://www.kymjs.com/) on 10/26/15.
 */
public class MVPFragment extends FragmentPresenter<SimpleDelegate> implements View.OnClickListener {
    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        //可以同时对多个控件设置同一个点击事件,后面id参数可以传多个
        viewDelegate.setOnClickListener(this, R.id.button1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                viewDelegate.setText("你点击了button");
                break;
        }
    }
}
