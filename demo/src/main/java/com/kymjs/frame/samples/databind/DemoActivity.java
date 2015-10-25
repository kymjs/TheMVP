package com.kymjs.frame.samples.databind;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import com.kymjs.frame.DataBindActivity;
import com.kymjs.frame.SimpleLoader;
import com.kymjs.frame.samples.R;
import com.kymjs.frame.samples.mvp.SimpleDelegate;

/**
 * 这里就偷懒直接复用simple里面的simpleDelegate视图代理了
 * 同样也说明了，我们可以不用做任何改变就把一个视图层的东西拿来复用
 *
 * @author kymjs (http://www.kymjs.com/) on 10/24/15.
 */
public class DemoActivity extends DataBindActivity<SimpleDelegate, JavaBean> {

    JavaBean data = new JavaBean("名字");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //模拟数据改变(比如也可以写在网络请求成功的时候改变数据)
        viewDelegate.get(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setName("改变了数据");
                //通知数据发生了改变
                notifyDataSetChange();
            }
        });
    }

    /**
     * 将数据与View绑定，这样当数据改变的时候，框架就知道这个数据是和哪个View绑定在一起的，就可以自动改变ui
     * 当数据改变的时候，会回调本方法。
     *
     * @param data
     */
    @Override
    public void viewBindModel(JavaBean data) {
        super.viewBindModel(data);
        viewDelegate.setText(data.getName());
    }

    /**
     * 视图监听的监听器id，每个视图的监听器都应该有唯一id
     *
     * @return
     */
    @Override
    protected int getLoaderId() {
        return 0;
    }

    /**
     * 使用框架中已经实现的最简单的DataLoader
     * 当然，也可以自己继承SimpleLoader或参考其实现自己写一个数据Loader
     *
     * @param args
     * @return
     */
    @Override
    protected Loader<JavaBean> getDataLoader(Bundle args) {
        return new SimpleLoader<>(this, data);
    }

    /**
     * 框架需要拿到你的视图层代理类
     *
     * @return
     */
    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

}
