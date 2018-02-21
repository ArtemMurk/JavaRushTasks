package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        PrintStream streamMain = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileOutputStream fileOut = new FileOutputStream(fileName);
        ByteArrayOutputStream newOutByte = new ByteArrayOutputStream();
        PrintStream streamNew = new PrintStream(newOutByte);
        System.setOut(streamNew);

        testString.printSomething();

        System.setOut(streamMain);

        byte[] buffer = newOutByte.toByteArray();
        fileOut.write(buffer);
        fileOut.close();
        System.out.println(newOutByte.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

