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
package com.kymjs.frame;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.kymjs.frame.model.IModel;

/**
 * Model数据来源，数据加载器的实现
 * Model data loader
 *
 * @param <T> 要加载的数据的类型
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public abstract class DataLoader<T extends IModel> extends AsyncTaskLoader<T> {
    protected T data;

    public DataLoader(Context context, T data) {
        super(context);
        this.data = data;
    }
}
