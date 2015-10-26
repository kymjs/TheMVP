package com.kymjs.frame.samples.demo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kymjs.frame.samples.R;

/**
 * 为了说明MVPFragment用法而存在，一个普通Activity外壳，
 *
 * @author kymjs (http://www.kymjs.com/) on 10/26/15.
 */
public class ShellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new MVPFragment())
                .commit();
    }
}
