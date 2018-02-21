package com.javarush.task.task37.task3707;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AmigoSet<String> set = new AmigoSet<>();
        set.add("fd");
        set.add("fd2");
        set.add("fd3");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/home/artem/test/fileNew.txt"));
        outputStream.writeObject(set);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/home/artem/test/fileNew.txt"));

        AmigoSet<String> setSer = (AmigoSet<String>) inputStream.readObject();
    }
}
