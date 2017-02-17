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
package com.kymjs.themvp.samples.demo4;

import com.kymjs.themvp.databind.DataBinder;

/**
 * 设值器，将数据与视图显示绑定，会在数据改变时调用
 *
 * @author kymjs (http://www.kymjs.com/) on 10/30/15.
 */
public class Demo4DataBinder implements DataBinder<FragmentDelegate, User> {

    @Override
    public void viewBindModel(FragmentDelegate viewDelegate, User user) {
        if (user != null && user.getAge() != null && user.getName() != null) {
            viewDelegate.setResult(user.getName(), user.getAge());
        }
    }
}
