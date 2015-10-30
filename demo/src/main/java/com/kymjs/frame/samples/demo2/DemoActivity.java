/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kymjs.frame.samples.demo2;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import com.kymjs.frame.databind.DataBindActivity;
import com.kymjs.frame.databind.SimpleLoader;
import com.kymjs.frame.samples.R;
import com.kymjs.frame.samples.demo1.SimpleDelegate;

/**
 * 这里就偷懒直接复用demo1里面的simpleDelegate视图代理了
 * 同样也说明了，我们可以不用做任何改变就把一个视图层的东西拿来复用
 *
 * @author kymjs (http://www.kymjs.com/) on 10/24/15.
 */
public class DemoActivity extends DataBindActivity<SimpleDelegate, JavaBean> {

    JavaBean data = new JavaBean("名字");

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
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
