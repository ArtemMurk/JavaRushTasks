package com.javarush.task.task20.task2003;


import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        InputStream streamIn = new FileInputStream(name);
        load(streamIn);
        reader.close();
        streamIn.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> propMap: properties.entrySet()) {
            prop.setProperty(propMap.getKey(), propMap.getValue());
        }
        prop.store(outputStream, null);
        outputStream.close();



        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
            Properties prop = new Properties();
            prop.load(inputStream);

            Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        OutputStream fileOut = new FileOutputStream("/home/artem/primer2.properties");
        solution.save(fileOut);
    }
}
