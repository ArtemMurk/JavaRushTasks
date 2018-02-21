package com.javarush.task.task22.task2208;

import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("name",null);
        map.put("age",null);
        map.put("country",null);
        map.put("prof",null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringData = new StringBuilder();

        if (params != null) {
            for (Map.Entry<String, String> pair : params.entrySet()) {
                if (pair.getValue() != null && !pair.getValue().equals("null")) {
                    stringData.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
                }
            }
            if(stringData.length() != 0) stringData.delete(stringData.length() - 5, stringData.length());
        }
        return stringData.toString();
    }
}
