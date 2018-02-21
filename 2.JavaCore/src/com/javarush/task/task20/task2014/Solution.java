package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream ous = new FileOutputStream("/home/artem/primer1.txt");
        InputStream ins = new FileInputStream("/home/artem/primer1.txt");

        ObjectOutputStream outObj = new ObjectOutputStream(ous);
        ObjectInputStream inObj = new ObjectInputStream(ins);

        Solution savedObject = new Solution(32);
        outObj.writeObject(savedObject);


        Solution loadObject = (Solution) inObj.readObject();

        System.out.println(savedObject.string.equals(loadObject.string));

        outObj.close();
        inObj.close();

        System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
