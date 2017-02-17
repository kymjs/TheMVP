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
package com.kymjs.themvp.samples.demo6;

import android.os.Bundle;
import android.view.View;

import com.kymjs.themvp.presenter.ActivityPresenter;
import com.kymjs.themvp.samples.R;
import com.kymjs.themvp.samples.demo1.SimpleDelegate;

import de.greenrobot.event.EventBus;

/**
 * 使用EvenBus实现简易数据绑定
 *
 * @author kymjs (http://www.kymjs.com/) on 10/30/15.
 */
public class Demo6Activity extends ActivityPresenter<SimpleDelegate> {

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Demo6Data data = new Demo6Data();
                data.setName("点击了数据，修改名字");
            }
        }, R.id.button1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    public void onEventMainThread(Demo6Data data) {
        viewDelegate.setText(data.getName());
    }
}
