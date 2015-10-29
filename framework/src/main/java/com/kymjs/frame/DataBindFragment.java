package com.kymjs.frame;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;

import com.kymjs.frame.model.IModel;
import com.kymjs.frame.presenter.FragmentPresenter;
import com.kymjs.frame.view.IDelegate;

/**
 * 集成数据-视图绑定的Fragment基类(Presenter层)
 *
 * @param <T> View层代理类
 * @param <D> Model层数据类
 * @author kymjs (http://www.kymjs.com/) on 10/26/15.
 */
public abstract class DataBindFragment<T extends IDelegate, D extends IModel> extends
        FragmentPresenter<T> implements LoaderManager.LoaderCallbacks<D> {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLoaderManager().initLoader(getLoaderId(), null, this);
    }

    protected int getLoaderId() {
        return 0;
    }

    protected abstract Loader<D> getDataLoader(Bundle args);

    public void notifyDataSetChange() {
        getLoaderManager().restartLoader(getLoaderId(), null, this);
    }

    public void viewBindModel(D data) {
    }

    @Override
    public Loader<D> onCreateLoader(int id, Bundle args) {
        return getDataLoader(args);
    }

    @Override
    public void onLoadFinished(Loader<D> loader, D data) {
        viewBindModel(data);
    }

    @Override
    public void onLoaderReset(Loader<D> loader) {
    }
}
