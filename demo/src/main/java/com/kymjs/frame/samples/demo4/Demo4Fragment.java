package com.kymjs.frame.samples.demo4;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import com.kymjs.frame.DataBindFragment;
import com.kymjs.frame.SimpleLoader;
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
