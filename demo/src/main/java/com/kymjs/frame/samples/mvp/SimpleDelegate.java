package com.kymjs.frame.samples.mvp;

import android.widget.TextView;

import com.kymjs.frame.samples.R;
import com.kymjs.frame.view.AppDelegate;

/**
 * View视图层，完全移除与Presenter业务逻辑的耦合
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public class SimpleDelegate extends AppDelegate {

    private TextView textView;

    @Override
    public int getRootLayoutId() {
        return R.layout.delegate_simple;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        textView = bindView(R.id.text);
        textView.setText("在视图代理层创建布局");
    }

    public void setText(String text) {
        //get(id)等同于bindview(id)
        if (textView == null) textView = get(R.id.text);
        textView.setText(text);
    }
}