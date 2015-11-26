package com.test;


import java.net.URL;
import java.net.URLClassLoader;

/**
 * ◊”ClassLoader”≈œ»
 * Created by yuanquan.ld on 2015/11/26.
 */
public class ChildPriorityClassLoader extends URLClassLoader{
    public ChildPriorityClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        try {
            Class c = findLoadedClass(name);
            if (c == null) {
                c = findClass(name);
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        } catch (Exception e) {
            return super.loadClass(name, resolve);
        }
    }


}
