package com.kymjs.frame.samples.demo5;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.kymjs.frame.samples.R;
import com.kymjs.frame.view.AppDelegate;

/**
 * 使用Butterknife与EvenBus
 *
 * @author kymjs (http://www.kymjs.com/) on 10/28/15.
 */
public class Demo5Delegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_toolbar;
    }

    @Override
    public int getOptionsMenuId() {
        return R.menu.menu;
    }

    public Toolbar getToolbar() {
        return get(R.id.toolbar);
    }

    public void setText(String text) {
        TextView textView = get(R.id.text);
        textView.setText(text);
    }
}
