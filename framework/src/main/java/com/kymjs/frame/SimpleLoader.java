package com.kymjs.frame;

import android.content.Context;

import com.kymjs.frame.model.IModel;

/**
 * Model数据来源，最简单的实现
 * Model data simple loader
 *
 * @param <T> 要加载的数据的类型
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public class SimpleLoader<T extends IModel> extends DataLoader<T> {

    public SimpleLoader(Context context, T data) {
        super(context, data);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (data != null) {
            deliverResult(data);
        } else {
            forceLoad();
        }
    }

    @Override
    public T loadInBackground() {
        return data;
    }
}
