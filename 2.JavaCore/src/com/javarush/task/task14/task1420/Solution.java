package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1;
        int num2;

        num1 = Integer.parseInt(reader.readLine());
        num2 = Integer.parseInt(reader.readLine());
        if (num1<=0)
            throw new Exception();
        if (num2<=0)
            throw  new Exception();


        int delit;
        if (num1 < num2)
            delit = num1;
        else delit = num2;

        int topDelit=0;
        for (int i = 1; i <= delit ; i++) {
            if (num1%i == 0 && num2%i == 0)
                topDelit = i;
        }

        System.out.println(topDelit);

    }
}
