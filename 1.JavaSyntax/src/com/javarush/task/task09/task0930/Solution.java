package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        int n1 = -1;
        int n2 = -1;
        String a;
        String b;

        for (int i = 0; i < array.length ; i++) {
            if (!isNumber(array[i])){
            if (n1 != -1){
                n2 = i;
                if (isGreaterThan(array[n1], array[n2])){
                    a= array[n1];
                    b = array[n2];
                    array[n1] = b;
                    array[n2] = a;
                    n1 = -1;
                    n2 = -1;
                    i = -1;
                }
                else n1=i;

            }
            else n1 =i;
            }
        }

        n1 = -1;
        n2 = -1;

        for (int i = 0; i < array.length ; i++) {
            if (isNumber(array[i])){
                if (n1 != -1){
                    n2 = i;
                    if (Integer.parseInt(array[n1]) < Integer.parseInt(array[n2])){
                        a= array[n1];
                        b = array[n2];
                        array[n1] = b;
                        array[n2] = a;
                        n1 = -1;
                        n2 = -1;
                        i = -1;
                    }
                    else n1=i;

                }
                else n1 =i;
            }
        }
        //напишите тут ваш код

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
