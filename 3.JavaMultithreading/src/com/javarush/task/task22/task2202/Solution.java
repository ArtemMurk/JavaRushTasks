package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string==null) throw new TooShortStringException();

        String[] buffStr = string.split(" ");
        if(buffStr.length<5) throw new TooShortStringException();
        return buffStr[1]+" "+buffStr[2]+" "+ buffStr[3]+" "+buffStr[4];

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
