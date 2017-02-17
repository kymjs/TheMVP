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
package com.kymjs.themvp.samples.demo2;

import android.view.View;

import com.kymjs.themvp.databind.DataBindActivity;
import com.kymjs.themvp.databind.DataBinder;
import com.kymjs.themvp.samples.R;
import com.kymjs.themvp.samples.demo1.SimpleDelegate;

/**
 * 这里就偷懒直接复用demo1里面的simpleDelegate视图代理了
 * 同样也说明了，我们可以不用做任何改变就把一个视图层的东西拿来复用
 *
 * @author kymjs (http://www.kymjs.com/) on 10/24/15.
 */
public class DemoActivity extends DataBindActivity<SimpleDelegate> {

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
                notifyModelChanged(data);
            }
        });
    }

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    public DataBinder getDataBinder() {
        return new Demo2DataBinder();
    }
}
