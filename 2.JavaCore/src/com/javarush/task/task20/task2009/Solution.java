package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public static void serializeStatic(ObjectOutputStream oos) throws IOException {
            oos.writeBytes(staticString);
        }
        public static void deserializeStatic(ObjectInputStream ois) throws IOException{
            staticString=ois.readLine();
        }
    }

    public static void main(String[] args) {

    }
}
