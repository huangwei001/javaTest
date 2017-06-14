package com.java.Serializable;

/**
 * Created by huangwei on 2017/6/9.
 */
public class Dog extends Animal{
    public String furColor;
    public Dog(String name,String furColor) {
        super(name);
        this.furColor = furColor;
    }

    @Override
    public void enjoy() {
    System.err.println("SB叫");

    }
}
