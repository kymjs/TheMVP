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

import android.widget.EditText;
import android.widget.TextView;

import com.kymjs.themvp.samples.R;
import com.kymjs.themvp.view.AppDelegate;

/**
 * @author kymjs (http://www.kymjs.com/) on 10/26/15.
 */
public class FragmentDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        EditText et = get(R.id.editText);
        EditText et2 = get(R.id.editText2);
        et.setHint("姓名");
        et2.setHint("年龄");
    }

    public String getText(int id) {
        EditText et = get(id);
        return et.getText().toString();
    }

    public void setResult(String name, String age) {
        TextView textView = get(R.id.text);
        textView.setText(String.format("姓名+ %s + 年龄 + %s", name, age));
    }
}
