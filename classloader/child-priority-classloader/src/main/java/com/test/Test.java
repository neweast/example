package com.test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuanquan.ld on 2015/11/26.
 */
public class Test {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Test t = new Test();
        ClassLoader cl = new ChildPriorityClassLoader(new URL[]{new URL("file:" + t.getClass().getProtectionDomain().getCodeSource().getLocation().getFile())});
        Class<?> myDouble = cl.loadClass("com.test.Double");
        System.out.println(myDouble.getMethod("toString").invoke(myDouble.newInstance()));
        System.out.println(myDouble.getMethod("toString").invoke(myDouble.newInstance()));
        System.out.println(cl.getClass().getClassLoader().toString());
        Double2 double2 = new Double2();
        System.out.println(double2.getClass().getClassLoader().toString());
    }
}
