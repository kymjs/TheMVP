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
package com.kymjs.frame.samples.demo4;

import android.os.Bundle;
import android.view.View;

import com.kymjs.frame.samples.R;
import com.kymjs.frame.samples.databinding.FragmentUserBinding;
import com.kymjs.themvp.databind.DataBindFragment;

/**
 * fragment使用databinding的例子
 *
 * @author kymjs (http://www.kymjs.com/) on 10/26/15.
 */
public class Demo4Fragment extends DataBindFragment<FragmentDelegate, FragmentUserBinding> {
    private User data = new User();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setUser(data);
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        /**
         *此处也可以像demo2里面使用databinding去设置点击事件
         */
        viewDelegate.get(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setName("设置名字");
                data.setAge("设置年龄");
                binding.setUser(data);
            }
        });
    }

    @Override
    protected Class<FragmentDelegate> getDelegateClass() {
        return FragmentDelegate.class;
    }
}
