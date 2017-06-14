package com.java.Serializable;

/**
 * Created by huangwei on 2017/6/9.
 */
public class blueCat extends Cat{

    public String eyeColor;

    public blueCat(String name, String eyeColor) {
        super(name,eyeColor);
    }

    public void enjoy() {
        System.err.println("blueCat叫");
    }
}
