package com.java.Serializable;

/**
 * Created by huangwei on 2017/6/9.
 */
public  class Cat extends Animal{

    public String eyeColor;

    public Cat(String name,String eyeColor) {
        super(name);
        this.eyeColor = eyeColor;
    }

    @Override
    public void enjoy() {
        System.err.println("蓝猫叫。。。。。");
    }
}
