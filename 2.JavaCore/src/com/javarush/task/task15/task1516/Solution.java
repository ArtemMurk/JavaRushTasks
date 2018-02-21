package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public  int intVar;
    public  double doubleVar;
    public  Double DoubleVar;
    public  boolean booleanVar;
    public  Object ObjectVar;
    public  Exception ExceptionVar;
    public  String StringVar;
    public static void main(String[] args) {
        Solution dick = new Solution();
        System.out.println(dick.intVar);
        System.out.println(dick.doubleVar);
        System.out.println(dick.DoubleVar);
        System.out.println(dick.booleanVar);
        System.out.println(dick.ObjectVar);
        System.out.println(dick.ExceptionVar);
        System.out.println(dick.StringVar);

    }
}
