package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader fileBuff = new BufferedReader(fileReader);

        while (fileBuff.ready()){
            String[] data = fileBuff.readLine().split(" ");
            StringBuffer nameBuff = new StringBuffer();
            for (int i = 0; i < data.length-3 ; i++) {
                nameBuff.append(data[i]+" ");
            }
            String name = nameBuff.toString();

            int year = Integer.parseInt(data[data.length-1])-1900;
            int month = Integer.parseInt(data[data.length-2])-1;
            int date = Integer.parseInt(data[data.length-3]);
            PEOPLE.add(new Person(name.trim(), new Date(year,month,date)));
        }
        fileReader.close();

    }
}
