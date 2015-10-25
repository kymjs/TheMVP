package com.kymjs.frame.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kymjs.frame.view.IDelegate;

/**
 * Presenter base class for Activity
 * Presenter层的实现基类
 *
 * @param <T> View delegate class type
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public abstract class ActivityPresenter<T extends IDelegate> extends AppCompatActivity {
    protected T viewDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            viewDelegate = getDelegateClass().newInstance();
            viewDelegate.init(getLayoutInflater(), null, savedInstanceState);
            setContentView(viewDelegate.getRootView());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        bindEvenListener();
    }

    protected void bindEvenListener() {
    }

    protected abstract Class<T> getDelegateClass();
}
