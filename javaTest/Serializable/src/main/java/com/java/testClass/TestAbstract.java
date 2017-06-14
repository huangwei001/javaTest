package com.java.testClass;

import com.java.Serializable.Dog;
import com.java.Serializable.blueCat;

/**
 * Created by huangwei on 2017/6/9.
 */
public class TestAbstract {


    public static void main(String[] args){


        Dog dog = new Dog("test1","black");
        dog.enjoy();
        blueCat blueCat = new blueCat("test2","");
        blueCat.enjoy();
    }
}
