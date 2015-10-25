package com.kymjs.frame.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * View delegate base class
 * 视图层代理的接口协议
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public interface IDelegate {
    void init(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    View getRootView();
}
