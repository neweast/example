package com.test;

/**
 * Created by yuanquan.ld on 2015/11/26.
 */
public class Double {
    private Double2 double2;
    private Integer integer;
    @Override
    public String toString() {
        double2 = new Double2();
        double2.setI(3);
        integer = new Integer(1);
        return "my double!" + double2.getClass().getClassLoader().toString();
    }
}
