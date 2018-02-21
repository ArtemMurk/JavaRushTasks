package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(1d, "DFs");
        labels.put(12d, "DFs2");
        labels.put(13d, "DFs3");
        labels.put(14d, "DFs4");
        labels.put(15d, "DFs5");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
