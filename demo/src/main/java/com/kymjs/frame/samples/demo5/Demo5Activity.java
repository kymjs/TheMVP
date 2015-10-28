package com.kymjs.frame.samples.demo5;

import android.view.MenuItem;
import android.widget.Toast;

import com.kymjs.frame.presenter.ActivityPresenter;
import com.kymjs.frame.samples.R;

/**
 * 使用EvenBus解耦
 *
 * @author kymjs (http://www.kymjs.com/) on 10/28/15.
 */
public class Demo5Activity extends ActivityPresenter<Demo5Delegate> {

    @Override
    protected Class<Demo5Delegate> getDelegateClass() {
        return Demo5Delegate.class;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}