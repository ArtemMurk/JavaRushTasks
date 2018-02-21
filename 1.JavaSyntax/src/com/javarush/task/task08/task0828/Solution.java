package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        int number = 1;
        String outDate = "January";
        String date = reader.readLine();
        for (int i = 0; i < 12 ; i++) {
            if (months.get(i).equals(date)) {
                number = i + 1;
                outDate = months.get(i);
            }
        }
        System.out.println(outDate+" is "+number+" month");
        //напишите тут ваш код
    }
}
