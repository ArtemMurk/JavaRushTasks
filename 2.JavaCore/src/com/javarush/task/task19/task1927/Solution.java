package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream streamMain = System.out;
        ByteArrayOutputStream byteArray= new ByteArrayOutputStream();
        PrintStream streamNew = new PrintStream(byteArray);
        System.setOut(streamNew);
        testString.printSomething();
        System.setOut(streamMain);
        int count = 0;
        Pattern p = Pattern.compile(".*\\n");
        Matcher m = p.matcher(byteArray.toString());
        while (m.find()){
            System.out.print(m.group());
            count++;
            if (count == 2) {
                count = 0;
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
