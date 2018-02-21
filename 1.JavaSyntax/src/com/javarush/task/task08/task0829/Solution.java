package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> addressesFamily = new ArrayList<String>();
        while (true) {
            String value = reader.readLine();
            if (value.isEmpty()) break;

            addressesFamily.add(value);
        }

        //read home number
        String city = reader.readLine();
        for (int i = 0; i < addressesFamily.size() ; i++) {
            if (city.equals(addressesFamily.get(i)))
                System.out.println(addressesFamily.get(i+1));
        }

    }
}
