package com.kymjs.frame.samples.databind;

import com.kymjs.frame.model.IModel;

/**
 * 一个简单的javabean类
 * javabean必须实现Imodel接口
 *
 * @author kymjs (http://www.kymjs.com/) on 10/24/15.
 */
public class JavaBean implements IModel {
    private String name;

    public JavaBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
