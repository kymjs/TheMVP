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
import android.support.v4.content.Loader;
import android.view.View;

import com.kymjs.frame.databind.DataBindFragment;
import com.kymjs.frame.databind.SimpleLoader;
import com.kymjs.frame.samples.R;

/**
 * @author kymjs (http://www.kymjs.com/) on 10/26/15.
 */
public class Demo4Fragment extends DataBindFragment<FragmentDelegate, User> {
    private User data = new User();

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.get(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setName(viewDelegate.getText(R.id.editText));
                data.setAge(viewDelegate.getText(R.id.editText2));
                notifyDataSetChange();
            }
        });
    }

    @Override
    public void viewBindModel(User user) {
        super.viewBindModel(user);
        if (user != null && user.getAge() != null && user.getName() != null) {
            viewDelegate.setResult(user.getName(), user.getAge());
        }
    }

    @Override
    protected Loader<User> getDataLoader(Bundle args) {
        return new SimpleLoader(getActivity(), data);
    }

    @Override
    protected Class<FragmentDelegate> getDelegateClass() {
        return FragmentDelegate.class;
    }
}
