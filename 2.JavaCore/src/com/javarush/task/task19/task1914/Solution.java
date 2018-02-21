package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream mainStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(mainStream);

        String[] split = outputStream.toString().split(" ");
        int c = 0;
        switch (split[1]){
           case  "+":
               c = Integer.parseInt(split[0])+Integer.parseInt(split[2]);
               break;

            case "-":
                c = Integer.parseInt(split[0])-Integer.parseInt(split[2]);
                break;

            case "*":
                c = Integer.parseInt(split[0])*Integer.parseInt(split[2]);
                break;
        }

        String result = outputStream.toString().trim() + " " + String.valueOf(c);
        System.out.printf(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

