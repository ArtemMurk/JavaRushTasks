package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(reader.readLine()));
        int maximum = list.get(0);
        for (int i = 1; i < number ; i++) {
            list.add(Integer.parseInt(reader.readLine()));
            if (list.get(i) > maximum)
                maximum = list.get(i);
        }



        //напишите тут ваш код

        System.out.println(maximum);
    }
}
