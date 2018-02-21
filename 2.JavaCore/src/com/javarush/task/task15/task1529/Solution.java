package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
    reset();
        //add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String paramF = reader.readLine();
            if (paramF.equals("helicopter")) result = new Helicopter();
            if (paramF.equals("plane")) result = new Plane(12);
            reader.close();
        }
        catch (Exception e){}
        //add your code here - добавьте код тут
    }
}
