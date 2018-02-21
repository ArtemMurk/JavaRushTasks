package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String i = reader.readLine();

            if (!i.equals("exit")) {
                try {

                if (i.contains(".")) {
                    print(Double.parseDouble(i));}
                    else if (Integer.parseInt(i) < 128 && Integer.parseInt(i) > 0) {
                        print(Short.parseShort(i));}
                    else if (Integer.parseInt(i) >= 128 || Integer.parseInt(i) <= 0) {
                        print(Integer.parseInt(i));
                    }
                }
                catch (NumberFormatException e){
                    print(i);

                }
            } else break;
        }
        reader.close();
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
