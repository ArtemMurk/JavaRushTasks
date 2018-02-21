package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            if (args[0].matches("[A-Za-z0-9]+") && args[0].length()<256){
                for (int i = 2; i <=36 ; i++) {
                    try {
                        new BigInteger(args[0],i);
                        System.out.println(i);
                        return;

                    } catch (NumberFormatException e) {

                    }
                }
                System.out.println("incorrect");
            } else System.out.println("incorrect");
        } catch (Exception e) {

        }

        //напишите тут ваш код
    }
}