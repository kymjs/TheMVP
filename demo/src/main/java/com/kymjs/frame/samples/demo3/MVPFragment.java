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
        viewDelegate.get(R.id.button1).setOnClickListener(this);
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
