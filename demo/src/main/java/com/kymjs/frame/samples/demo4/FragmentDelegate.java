package com.kymjs.frame.samples.demo4;

import android.widget.EditText;
import android.widget.TextView;

import com.kymjs.frame.samples.R;
import com.kymjs.frame.view.AppDelegate;

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

    public void setResult(User user) {
        TextView textView = get(R.id.text);
        textView.setText(String.format("姓名+ %s + 年龄 + %s", user.getName(), user.getAge()));
    }
}
