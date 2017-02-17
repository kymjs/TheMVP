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
package com.kymjs.themvp.samples.demo5;

import android.view.MenuItem;
import android.widget.Toast;

import com.kymjs.themvp.presenter.ActivityPresenter;
import com.kymjs.themvp.samples.R;

/**
 * Toolbar与Menu
 *
 * @author kymjs (http://www.kymjs.com/) on 10/28/15.
 */
public class Demo5Activity extends ActivityPresenter<Demo5Delegate> {

    @Override
    protected Class<Demo5Delegate> getDelegateClass() {
        return Demo5Delegate.class;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}