package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    public Solution(String name) {}
    private Solution() {}
    protected Solution(String name, int age) {}
    Solution(int age, String name) {}

}

