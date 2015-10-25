package com.kymjs.frame;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.kymjs.frame.model.IModel;

/**
 * Model数据来源，数据加载器的实现
 * Model data loader
 *
 * @param <T> 要加载的数据的类型
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public abstract class DataLoader<T extends IModel> extends AsyncTaskLoader<T> {
    protected T data;

    public DataLoader(Context context, T data) {
        super(context);
        this.data = data;
    }
}
