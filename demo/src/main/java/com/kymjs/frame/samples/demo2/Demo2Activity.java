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
import android.view.View;

import com.kymjs.frame.samples.databinding.DelegateDemoBinding;
import com.kymjs.themvp.databind.DataBindActivity;

/**
 * activity使用databinding的例子
 *
 * @author kymjs (http://www.kymjs.com/) on 10/24/15.
 */
public class Demo2Activity extends DataBindActivity<Demo2Delegate, DelegateDemoBinding> {

    JavaBean data = new JavaBean("名字");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setJavabean(data);
        binding.setPresenter(this);
    }

    public void clickButton(View view) {
        data.setName("改变了数据");
        //通知数据发生了改变
        binding.setJavabean(data);
    }

    @Override
    protected Class<Demo2Delegate> getDelegateClass() {
        return Demo2Delegate.class;
    }
}
