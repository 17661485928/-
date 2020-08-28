package com.example.demo.test;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description:
 * @date 2020/8/24 11:40
 */
public enum ColorEnum {

    red(1,"红色"),

    black(2,"黑色");

    int color;
    String desc;

    ColorEnum(int color, String desc) {
        this.color = color;
        this.desc = desc;
    }
}
