package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       ArrayList<String> listObj = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listV1 = new ArrayList<>();
        String[] list;

        String url = reader.readLine();
        reader.close();

        int uu = url.indexOf('?');
        url = url.substring(uu+1);

        list = url.split("&");

        for (String lists: list) {
            String[] catcher = lists.split("=");
            listV1.add(catcher[0]);
            if (catcher[0].equals("obj")){ listObj.add(catcher[1]);}
        }

        for (String lists: listV1){
            System.out.print(lists + " ");
        }

        System.out.println();
        for (String lists: listObj) {
                try {
                    alert(Double.parseDouble(lists));

                }
                catch (NumberFormatException e){
                    alert(lists);
                }
        }

     reader.close();   //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
