package com.java.testClass;

import com.java.Serializable.Person;

import java.io.*;
import java.text.MessageFormat;

/**
 * Created by huangwei on 2017/6/8.
 */
public class TestSerializableAndDeserizalizable {

    public static void main(String[] args) throws Exception {
            SerializePerson();
            Person person = DeserializePerson();
            System.err.println(MessageFormat.format("name={0},age={1},sex={2}",person.getName(), person.getAge(), person.getSex()));

    }

    private static void SerializePerson() throws Exception{
        Person person = new Person();
        person.setAge(1);
        person.setName("test");
        person.setSex("中性");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("F:\\TestFile\\Person.txt")));
        outputStream.writeObject(person);
        System.err.println("Person序列化成功！！！");
        outputStream.close();
    }

    public static Person DeserializePerson() throws Exception{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("F:\\TestFile\\Person.txt")));
        Person person = (Person) inputStream.readObject();
        System.err.println("Person对象反序列化成功！！！");
        return person;
    }
}
